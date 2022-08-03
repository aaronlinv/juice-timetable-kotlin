package com.juice.timetable.ui.course

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.os.Bundle
import android.view.*
import android.widget.PopupWindow
import android.widget.Switch
import androidx.appcompat.widget.Toolbar
import androidx.datastore.preferences.core.edit
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import androidx.viewpager2.widget.ViewPager2
import cn.pedant.SweetAlert.SweetAlertDialog
import com.jaredrummler.materialspinner.MaterialSpinner
import com.juice.timetable.*
import com.juice.timetable.api.URI_COOL_APK
import com.juice.timetable.api.URL_ONE_WEEK
import com.juice.timetable.api.URL_SINGLE_WEEK_KEY
import com.juice.timetable.api.URL_WHOLE_WEEK
import com.juice.timetable.data.parse.ParseAllWeek
import com.juice.timetable.data.parse.ParseSingleWeek
import com.juice.timetable.data.parse.ParseVersion
import com.juice.timetable.data.source.Course
import com.juice.timetable.data.source.CourseViewBean
import com.juice.timetable.data.source.SingleWeekCourse
import com.juice.timetable.data.source.StuInfo
import com.juice.timetable.databinding.FragmentCourseBinding
import com.juice.timetable.repo.EduRepository
import com.juice.timetable.utils.DateUtils
import com.juice.timetable.utils.DisplayUtils
import com.juice.timetable.utils.LogUtils
import com.juice.timetable.utils.ToastyUtils
import com.juice.timetable.utils.VersionUtils.getVersionCode
import com.juice.timetable.viewmodel.AllWeekCourseViewModel
import com.juice.timetable.viewmodel.JuiceViewModelFactory
import com.juice.timetable.viewmodel.SingleWeekCourseViewModel
import com.juice.timetable.viewmodel.StuInfoViewModel
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.map
import java.time.LocalDate
import java.util.*

class CourseFragment : Fragment() {
    companion object {
        /**
         * 当前周，从 1 开始，表示第一周
         * 本地不存在 返回-1
         */
        var curWeek = -1

        /*
        第一周周一，示例：2016-08-16
         */
        var firstWeekMon = ""
        var enableShowMooc = false
        var enableRainbowMode = false
        var rainbowModeNum = 0
        var enableCheckVersion = true
        var lastCheckVersionDate: String? = null
        var initLoginKey = false
    }

    private var _binding: FragmentCourseBinding? = null

    private lateinit var toolbar: Toolbar
    private lateinit var vpCourse: ViewPager2

    private val singleWeekCourseViewModel: SingleWeekCourseViewModel by activityViewModels {
        JuiceViewModelFactory(
            requireActivity().application
        )
    }
    private val allWeekCourseViewModel: AllWeekCourseViewModel by activityViewModels {
        JuiceViewModelFactory(
            requireActivity().application
        )
    }
    private val stuInfoViewModel: StuInfoViewModel by activityViewModels {
        JuiceViewModelFactory(
            requireActivity().application
        )
    }
    private lateinit var mSlRefresh: SwipeRefreshLayout
    private lateinit var courseViewListAdapter: CourseViewListAdapter
    private val mCourseViewBeanList: MutableList<CourseViewBean> = ArrayList()
    private var mCurViewPagerNum = 0
    private lateinit var mSpinner: MaterialSpinner
    private lateinit var eduRepository: EduRepository

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private var version: String? = null
    private var description: String? = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCourseBinding.inflate(inflater, container, false)
        val root: View = binding.root

        vpCourse = binding.vpCourse
        mSlRefresh = binding.slRefresh

        //开启 tool bar
        setHasOptionsMenu(true)

        runBlocking {
            requireActivity().dataStore.data.map {
                curWeek = it[CUR_WEEK_KEY] ?: -1

            }.firstOrNull()

            requireActivity().dataStore.data.map {
                firstWeekMon = it[FIRST_WEEK_MON_KEY] ?: ""
            }.firstOrNull()

            requireActivity().dataStore.data.map {
                enableShowMooc = it[ENABLE_SHOW_MOOC] ?: false
            }.firstOrNull()

            requireActivity().dataStore.data.map {
                enableRainbowMode = it[ENABLE_RAINBOW_MODE] ?: false
            }.firstOrNull()

            requireActivity().dataStore.data.map {
                enableCheckVersion = it[ENABLE_CHECK_VERSION] ?: true
            }.firstOrNull()

            requireActivity().dataStore.data.map {
                enableRainbowMode = it[ENABLE_RAINBOW_MODE] ?: false
            }.firstOrNull()

            requireActivity().dataStore.data.map {
                lastCheckVersionDate = it[LAST_CHECK_VERSION_DATE]
            }.firstOrNull()

            requireActivity().dataStore.data.map {
                initLoginKey = it[INIT_LOGIN_KEY] ?: true
            }.firstOrNull()

            LogUtils.d("读取 DataStore 的当前周，并初始化静态变量：${curWeek}")
            LogUtils.d("读取 DataStore 的第一周周一，并初始化静态变量：${firstWeekMon}")
            LogUtils.d("读取 DataStore 的是否慕课，并初始化静态变量：${enableShowMooc}")
            LogUtils.d("读取 DataStore 的是否开启彩虹模式，并初始化静态变量：${enableRainbowMode}")
            LogUtils.d("读取 DataStore 的是否彩虹模式随机变量，并初始化静态变量：${rainbowModeNum}")
            LogUtils.d("读取 DataStore 的是否自动检查更新，并初始化静态变量：${enableCheckVersion}")
            LogUtils.d("读取 DataStore 的是否上次检查更新时间，并初始化静态变量：${lastCheckVersionDate}")
        }

        initCurrentWeek()
        initView()
        initCourse()

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 首次打开引导
        firstGuide()
        // 通知提醒明日课程
        // showTomorrowCourse()


        eduRepository = EduRepository()


        // 每次到这个界面都 获取数据并刷新界面
        if (MainActivity.refreshDate) {
            // 刷新动画
            mSlRefresh.isRefreshing = true
            refreshData()
            // 设置为 false
            MainActivity.refreshDate = false
        }

        // 首次登录

        LogUtils.d("首次登录标志：$initLoginKey")
        if (initLoginKey) {
            // 刷新动画
            mSlRefresh.isRefreshing = true
            refreshData()
            // 设置登录初始化标志
            CoroutineScope(Dispatchers.IO).launch {
                requireActivity().dataStore.edit { settings ->
                    // val currentCounterValue = settings[INIT_LOGIN_KEY] ?: 0
                    settings[INIT_LOGIN_KEY] = false
                }
            }
        }
        initEvent()
    }

    override fun onResume() {
        super.onResume()
        // 设置为可见 切换到其他界面会隐藏，所以这样要设置回可见
        mSpinner.visibility = View.VISIBLE
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onStop() {
        super.onStop()
        mSpinner.visibility = View.INVISIBLE
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.course_bar, menu)
    }

    /**
     * 自动检查更新，提示
     * 1. 开启检查，每次启动都检查更行
     * 2. 开启检查，并且忽略过，需要判断是否超过 7 天，超过则检查
     * 3. 关闭检查，永不检查
     */
    private fun checkUpdate() {
        if (!enableCheckVersion) {
            return
        }

        // 忽略过
        if (lastCheckVersionDate != null) {
            // 默认 7 天检查一次
            val date = LocalDate.parse(lastCheckVersionDate).plusDays(7)
            if (LocalDate.now().isBefore(date)) {
                return
            }
        }

        CoroutineScope(Dispatchers.Main).launch {
            withContext(Dispatchers.IO) {
                try {
                    LogUtils.d("爬虫线程启动")
                    val str: String = ParseVersion.getSource(URI_COOL_APK)

                    version = ParseVersion.getVersion(str)
                    description = ParseVersion.getVersionInfo(str)

                    LogUtils.d("酷安 id --> $version")
                    LogUtils.d("酷安 info --> $description")
                } catch (e: Exception) {
                    LogUtils.e("获取酷安版本失败")
                    e.printStackTrace()
                }
            }

            val currVersion = getVersionCode(requireActivity())
            LogUtils.d("本地 id --> $currVersion")

            if (version != currVersion) {
                binding.tvCheckIn.visibility = View.VISIBLE
            }

            // 更新检查
            binding.tvCheckIn.setOnClickListener {
                SweetAlertDialog(requireActivity(), SweetAlertDialog.NORMAL_TYPE)
                    .setTitleText(getString(R.string.new_version_dialog_title))
                    .setContentText(description?.replace(" ", "<br>"))
                    .setCancelText(resources.getString(R.string.no_quit_dialog_title))
                    .setConfirmText(resources.getString(R.string.ok_quit_dialog_title))
                    .setConfirmClickListener { sDialog ->
                        val uri = Uri.parse(URI_COOL_APK)
                        val intent = Intent(Intent.ACTION_VIEW, uri)
                        startActivity(intent)
                        sDialog.dismissWithAnimation()
                    }
                    .showCancelButton(true)
                    .setCancelClickListener { sDialog -> sDialog.cancel() }
                    .setNeutralText("忽略")
                    .setNeutralClickListener { sDialog ->
                        binding.tvCheckIn.visibility = View.GONE
                        sDialog.dismissWithAnimation()

                        CoroutineScope(Dispatchers.IO).launch {
                            requireActivity().dataStore.edit { settings ->
                                lastCheckVersionDate =
                                    LocalDate.now().toString()
                                settings[LAST_CHECK_VERSION_DATE] = lastCheckVersionDate!!
                            }
                            LogUtils.d("忽略版本：dataStore 设置新的检查时间：$lastCheckVersionDate")
                        }
                    }
                    .show()
            }
        }
    }

    // todo 初次向导
    private fun firstGuide() {
        /*        val showGuide: Boolean = PreferencesUtils.getBoolean(Constant.FIRST_LOGIN_GUIDE, false)
            if (showGuide) {
                LogUtils.d("显示首次登录 引导提示")
                // 显示引导
                showGuideView()
                // 首次登录引导显示一次，然后就置为false，在设置中可重置
                PreferencesUtils.putBoolean(Constant.FIRST_LOGIN_GUIDE, false)
            }*/
    }

    private fun showGuideView() {
    }

    private fun initEvent() {
        // 跳转当前周 图标监听
        toolbar.setOnMenuItemClickListener { item ->
            if (item.itemId == R.id.item_go_current_week) {
                jumpToCurWeek()
            }
            // 更多选项 图标监听
            if (item.itemId == R.id.item_more_option) {
                popupWindowEvent()
            }
            // 源科表 图标监听
            if (item.itemId == R.id.item_origin_course) {
                val controller: NavController = findNavController()
                controller.navigate(R.id.action_nav_home_to_courseWebViewFragment)
            }
            false
        }

        // 下拉刷新监听
        mSlRefresh.setOnRefreshListener { refreshData() }

        // 翻页显示 当前周
        vpCourse.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                mCurViewPagerNum = position
                // 设置 toolbar 显示当前周
                mSpinner.selectedIndex = position
            }
        })

        // ViewPager 课程被点击事件
        courseViewListAdapter.itemClickListener =
            object : CourseViewListAdapter.OnItemClickListener {
                override fun onClick(cou: Course, conflictList: List<Course>) {
                    LogUtils.d(
                        "课程被点击  -- > " + cou.couName + " 冲突列表 --> " + conflictList
                    )

                    // 撞课处理 撞课列表大于0 为撞课
                    if (conflictList.size > 0) {
                        // 遍历周课表 查询所有撞课课程
                        val sb = StringBuilder()
                        for (i in conflictList.indices) {
                            val conflictCou: Course = conflictList[i]
                            if (i > 0) {
                                sb.append("<br><br>")
                            }
                            sb.append(conflictCou.couName)
                                .append("<br>")
                                .append(getTeacherName(conflictCou.couID))
                                .append("&nbsp;&nbsp;")
                                .append(conflictCou.couRoom)
                                .append("&nbsp;&nbsp;")
                                .append(conflictCou.couStartNode).append("~")
                                .append(conflictCou.couEndNode).append("节")
                        }
                        SweetAlertDialog(requireActivity(), SweetAlertDialog.NORMAL_TYPE)
                            .setTitleText("<font color=\"red\">课程冲突</font>")
                            .setContentText(sb.toString())
                            .hideConfirmButton()
                            .show()
                        return
                    }

                    // 周课表没有老师所以要填充
                    var teacher = getTeacherName(cou.couID)
                    // 不为空 换行
                    if (teacher.isNotEmpty()) {
                        teacher = "$teacher<br>"
                    }
                    val sb = teacher + cou.couRoom
                    LogUtils.d("teacher == >$teacher")
                    LogUtils.d("cou.getCouRoom() == >" + cou.couRoom)
                    SweetAlertDialog(requireActivity(), SweetAlertDialog.NORMAL_TYPE)
                        .setTitleText(cou.couRoom)
                        .setContentText(sb)
                        .hideConfirmButton()
                        .show()
                }
            }

        // 第几周的下拉监听
        mSpinner.setOnItemSelectedListener { _, position, _, _ -> // 跳转到对应周
            vpCourse.setCurrentItem(position, true)
            LogUtils.d("点击了 下拉菜单 跳转到对应周索引：$position")
        }


    }

    private fun jumpToCurWeek() {
        val curWeekIndex = curWeek - 1
        // 如果是当前周，提示
        if (vpCourse.currentItem == curWeekIndex) {
            ToastyUtils.shortSuccess(requireActivity(), R.drawable.ic_mune_course, "已在当前周")

        } else {
            vpCourse.setCurrentItem(curWeekIndex, true)
        }
        LogUtils.d("跳转到当前周 -- > $curWeekIndex")
    }

    /**
     * 获取老师名字，没匹配到返回 "" 所以不需要 在后面加 br
     *
     * @param couId
     * @return
     */
    private fun getTeacherName(couId: Long?): String {
        // 如果没有匹配到老师 就直接显示空 ""
        var teach = ""
        // 可能传入 null
        if (couId == null) {
            return teach
        }
        val allWeekCourse: List<Course> = mCourseViewBeanList[0].allWeekCourse
        for (course in allWeekCourse) {
            if (course.couID == couId) {
                teach = course.couTeacher.toString()
                break
            }
        }
        return teach
    }

    /**
     * popupWindow的监听事件
     */
    @SuppressLint("ClickableViewAccessibility")
    private fun popupWindowEvent() {
        // 必须设置宽度
        val popupWindow = PopupWindow(
            requireView(),
            ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, true
        )
        popupWindow.animationStyle = androidx.navigation.ui.R.anim.nav_default_pop_enter_anim

        // 添加阴影
        popupWindow.elevation = 100f

        // 点击其他区域 PopUpWindow消失
        popupWindow.isTouchable = true
        popupWindow.setTouchInterceptor { _, _ -> // false 不拦截这个事件
            // 拦截了PopUpWindow 的onTouchEvent就不会被调用
            // popupWindow.dismiss()
            false
        }

        popupWindow.setBackgroundDrawable(ColorDrawable(-0x50506))
        val contentView: View =
            LayoutInflater.from(activity).inflate(R.layout.popupwindow, null)
        popupWindow.contentView = contentView
        popupWindow.showAsDropDown(toolbar, 0, 0, Gravity.RIGHT)
        val switchShowMooc = contentView.findViewById<Switch>(R.id.switch_show_mooc)

        // 初始化开关状态
        switchShowMooc.isChecked = enableShowMooc
        switchShowMooc.setOnCheckedChangeListener { _, isChecked ->
            LogUtils.d("慕课显示按钮 -- > $isChecked")
            if (isChecked) {
                ToastyUtils.longSuccess(
                    requireActivity(),
                    R.drawable.ic_mune_course,
                    "慕课显示开启，课表下方会显示所选慕课信息"
                )
            } else {
                ToastyUtils.shortSuccess(requireActivity(), R.drawable.ic_mune_course, "慕课显示已关闭")
            }

            enableShowMooc = isChecked

            // 通知 ViewPager 重新调整布局，不然慕课显示还会在
            courseViewListAdapter.notifyDataSetChanged()
            // 持久化

            CoroutineScope(Dispatchers.IO).launch {
                requireActivity().dataStore.edit { settings ->
                    settings[ENABLE_SHOW_MOOC] = isChecked
                    settings[FIRST_WEEK_MON_KEY] = firstWeekMon
                }
                LogUtils.d("dataStore 设置是否慕课：$enableShowMooc")
            }
        }
    }

    /**
     * 初始化课程数据
     */
    private fun initCourse() {
        courseViewListAdapter = CourseViewListAdapter()
        courseViewListAdapter.submitList(mCourseViewBeanList)
        updateCourse()
        vpCourse.adapter = courseViewListAdapter
        // 打开主页 跳转当前周


        // 不在周范围 显示第一周
        if (curWeek < 1 || curWeek > CourseView.MAX_WEEK) {
            curWeek = 1
        }
        vpCourse.setCurrentItem(curWeek - 1, false)
        // 设置 toolbar 显示当前周
        LogUtils.d("spinner 设置当前周 -- > $curWeek")
        mSpinner.selectedIndex = curWeek - 1
    }

    /**
     * 读取数据库 完整课表和周课表 更新到适配器
     */
    @SuppressLint("NotifyDataSetChanged")
    private fun updateCourse() {
        CoroutineScope(Dispatchers.Main).launch {
            val allWeekCourse: List<Course> = allWeekCourseViewModel.getAll()
            val singleWeekCourse: List<SingleWeekCourse> = singleWeekCourseViewModel.getAll()
            val weekSet: Set<Int> = singleWeekCourseViewModel.getWeek().toSet()
            println("所有课：$allWeekCourse")
            println("单周课：$singleWeekCourse")
            println("周set：$weekSet")

            val tempList: MutableList<CourseViewBean> = ArrayList()

            // 遍历得到慕课列表 慕课类型为 3
            val moocCourse: MutableList<Course> = ArrayList()
            for (course in allWeekCourse) {
                if (course.couWeekType == 3) {
                    moocCourse.add(course)
                }
            }

            // 传入第一周
            val firstWeekMonDate: LocalDate = if (firstWeekMon.isEmpty()) {
                LocalDate.now()
            } else {
                LocalDate.parse(firstWeekMon)
            }

            for (i in 1..25) {
                val courseViewBean =
                    CourseViewBean(
                        allWeekCourse.toMutableList(),
                        weekSet,
                        singleWeekCourse.toMutableList(),
                        moocCourse,
                        i,
                        firstWeekMonDate
                    )
                tempList.add(courseViewBean)
            }
            // 先清空原有的数据 再写入新数据
            mCourseViewBeanList.clear()
            mCourseViewBeanList.addAll(tempList)
            LogUtils.d("mCourseViewBeanList size -- > " + mCourseViewBeanList.size)

            // 原来的思路是每次从数据库获取 到新的BeanList 直接submitList
            // mCourseViewListAdapter.submitList(mCourseViewBeanList)
            // 这样带来的问题，每次下拉刷新，ViewPager都会强制跳到第一页，无论怎么etCurrentItem

            // 通知数据已经修改
            courseViewListAdapter.notifyDataSetChanged()
            // 跳到刷新之前所在的周，不然会跳转到第一周
            vpCourse.setCurrentItem(mCurViewPagerNum, false)
        }
    }

    /**
     * 初始化当前周
     */
    private fun initCurrentWeek() {
        // 不在周范围 显示第一周
        mCurViewPagerNum = if (curWeek < 1 || curWeek > CourseView.MAX_WEEK) {
            0
        } else {
            curWeek - 1
        }
    }

    /**
     * 初始化界面
     */
    private fun initView() {
        toolbar = requireActivity().findViewById(R.id.toolbar)
        // 显示 Toolbar 的右侧菜单按钮
        val menu = toolbar.menu
        menu.setGroupVisible(0, true)

        // 移除原有标题
        toolbar.title = ""

        // toolbar spinner 下拉菜单
        mSpinner = toolbar.findViewById(R.id.spinner)
        val weekArr = arrayOfNulls<String>(CourseView.MAX_WEEK)
        for (i in 0 until CourseView.MAX_WEEK) {
            weekArr[i] = "第 " + (i + 1) + " 周"
        }
        LogUtils.d("weekArr: ${weekArr.toList()}")
        mSpinner.setItems(weekArr.toList())
        mSpinner.setDropdownMaxHeight(700)

        // 初始化标题栏 只在 registerOnPageChangeCallback 中初始化 从后台切回标题栏不会显示周
        // 在 updateCourse 中初始
    }

    /**
     * 开始刷新数据，结束刷新动画
     */
    private fun refreshData() {
        CoroutineScope(Dispatchers.Main).launch {
            val stuInfo = stuInfoViewModel.getStuInfo()
            if (stuInfo == null) {
                LogUtils.i("用户信息为空，中止刷新课程数据")
                return@launch
            }

            val allCourse: String
            try {
                allCourse = eduRepository.url(URL_WHOLE_WEEK, requireActivity())
            } catch (e: Exception) {
                var message: String = e.message.toString()
                // 课表刷新有问题情况
                if (e.message == "您输入的用户名或是密码出错") {
                    // todo 逻辑优化
                    message = "教务网密码已被更改，请在退出并重新登录"
                }
                ToastyUtils.warn(requireActivity(), message)
                return@launch
            }
            if (allCourse.isEmpty()) {
                ToastyUtils.warn(requireActivity(), "获取课表信息失败")
            }
            LogUtils.d("获取完整课表结束，准备开始解析")
            val courses = ParseAllWeek.parseCourse(allCourse)

            val parseSemester: String = ParseAllWeek.semester
            // LogUtils.d("本地curSemester -- > $curSemester")
            LogUtils.d("爬取curSemester -- > $parseSemester")

            var curSemester = ""
            withContext(Dispatchers.IO) {
                requireActivity().dataStore.data.map {
                    curSemester = it[CUR_SEMESTER] ?: ""
                }.firstOrNull()

                LogUtils.d("读取 DataStore 的当前学期，并初始化变量：$curSemester")
            }

            // 不为当前学期就删除 所有周课表避免冲突，完整课表下面已经删了，不用担心
            if (curSemester != parseSemester) {
                singleWeekCourseViewModel.deleteAll()
                LogUtils.d("爬取的学期信息与本地不同，清除周课表")
                withContext(Dispatchers.IO) {
                    requireActivity().dataStore.edit { settings ->
                        settings[CUR_SEMESTER] = parseSemester
                    }
                    LogUtils.d("dataStore 设置当前学期：$parseSemester")
                }

            }

            if (courses.isEmpty()) {
                ToastyUtils.i(requireActivity(), "没有解析到完整课表\n可能是放假啦~")
                return@launch
            }

            // 先删除数据库 完整课表
            allWeekCourseViewModel.deleteAll()
            // 解析完整课表填充颜色
            for (cou in courses) {
                if (cou.couColor == null) {
                    cou.couColor = cou.couID?.toInt()
                }
            }
            // 填充完颜色将课程写入数据库
            allWeekCourseViewModel.addAll(courses)

            try {
                // 传入完整课表 用来匹配颜色和课程信息
                getOneWeekCou(stuInfo, courses)
            } catch (e: Exception) {
                ToastyUtils.warn(requireActivity(), e.message.toString())
                return@launch
            }
            LogUtils.d("setOnRefreshListener:获取完整课表和周课表 写入数据库结束")


            // 如果开启了彩虹模式 随机一个数
            LogUtils.d("是否开启了彩虹：$enableRainbowMode")
            if (enableRainbowMode) {
                val random = Random()
                // 随机一个1开始的数， 0代表关闭彩虹模式
                rainbowModeNum = random.nextInt(DisplayUtils.getColorCount() + 1)

                withContext(Dispatchers.IO) {
                    requireActivity().dataStore.edit { settings ->
                        settings[RAINBOW_MODE_NUM] = rainbowModeNum
                    }
                    LogUtils.d("dataStore 设置彩虹模式随机数：$rainbowModeNum")
                }
            }

            updateCourse()
            ToastyUtils.longSuccess(requireActivity(), R.drawable.ic_mune_course, "课表刷新成功")
        }
        mSlRefresh.isRefreshing = false
    }

    /**
     * 解析课表 获取本周、上两周、下两周的周课表 同时设置当前周
     *
     * @param allWeekCourse
     */
    private suspend fun getOneWeekCou(stuInfo: StuInfo, allWeekCourse: List<Course>) {
        withContext(Dispatchers.Main) {

            // 解析的周课表的 List
            var oneWeekCourList: List<SingleWeekCourse>

            // 先获取当前周课课程
            var oneWeekCouStr: String
            oneWeekCouStr = eduRepository.url(URL_ONE_WEEK, requireActivity())

            if (oneWeekCouStr.isEmpty() || oneWeekCouStr.contains("只能查最近几周的课表")) {
                throw Exception("没有查询到周课表信息")
            }

            oneWeekCourList = ParseSingleWeek.parseCourse(oneWeekCouStr)
            // 当前周 第 13 周 curWeek 就是13
            curWeek = oneWeekCourList[0].inWeek ?: throw Exception("获取当前周失败")

            LogUtils.d("获取第 <$curWeek> 周课表 -- > $oneWeekCourList")

            // 存储所有周课表
            val couList: MutableList<SingleWeekCourse> = ArrayList(oneWeekCourList)

            // 设置当前周
            firstWeekMon = DateUtils.getFirstWeekMon(curWeek, LocalDate.now()).toString()
            LogUtils.d("第一周星期一：$firstWeekMon")
            CoroutineScope(Dispatchers.IO).launch {
                requireActivity().dataStore.edit { settings ->
                    settings[CUR_WEEK_KEY] = curWeek
                    settings[FIRST_WEEK_MON_KEY] = firstWeekMon
                }
                LogUtils.d("dataStore 设置当前周为：$curWeek")
                LogUtils.d("dataStore 设置第一周星期一：$firstWeekMon")
            }

            // 获取数据库中存了哪些周的周课表
            val inWeek: Set<Int> = singleWeekCourseViewModel.getWeek().toSet()
            val set = HashSet(inWeek)
            LogUtils.d("数据库周课表已存在的周 -- > $set")

            // 要获取的周课表，0为当前周
            var week = 1

            // 数据库不包含上两周就解析上两周
            if (!set.contains(curWeek - 1) || !set.contains(curWeek - 2)) {
                week = -2
            }

            // 要删除数据库中的周
            val delList = hashSetOf<Int>()

            // 模拟登录获取课表数据
            while (week <= 2) {
                // 当前周跳过
                if (week == 0) {
                    week++
                    continue
                }
                oneWeekCouStr = eduRepository.url(
                    URL_ONE_WEEK,
                    mapOf(URL_SINGLE_WEEK_KEY to (curWeek + week).toString()),
                    requireActivity()
                )

                oneWeekCourList = ParseSingleWeek.parseCourse(oneWeekCouStr)
                LogUtils.d("获取第 <" + (curWeek + week) + "> 周课表 -- > " + oneWeekCourList)
                couList.addAll(oneWeekCourList)
                // 删除该数据库中 单前周和后两周的课表，避免冲突
                if (week > 0) {
                    delList.add(curWeek + week)
                }
                week++
            }
            // 添加当前周
            delList.add(curWeek)
            // 执行删除
            singleWeekCourseViewModel.deleteWeek(delList)
            LogUtils.d("删除周课表的周 -- > $delList")

            // 颜色的随机数(从完整课表总课程数开始)
            var colorNum = allWeekCourse.size
            LogUtils.d("allWeekCourse.size() -- > " + allWeekCourse.size)

            // 周课表课程存在完整课表中，就赋值上完整课表 id
            for (oneWeekCourse in couList) {
                var color: Long = -1
                val oneCouName: String = oneWeekCourse.couName?.replace(" ", "") ?: continue

                for (cou in allWeekCourse) {
                    // 去除空格
                    val wholeCouName: String? = cou.couName?.replace(" ", "")
                    if (oneCouName == wholeCouName) {
                        // 设置上课程 id 和颜色
                        oneWeekCourse.couID = cou.couID
                        if (cou.couID != null) {
                            color = cou.couID!!
                        }
                        LogUtils.d("在完整课表中找到了该课程并修改：$oneWeekCourse")
                        break
                    }
                }
                // 没有找到 可能是一些考试的显示
                // 取当前的完整课表的课数目为随机数
                if (color == -1L) {
                    LogUtils.d("没有在完整课表中找到当前课程 -- > " + oneWeekCourse.couName)
                    color = colorNum.toLong()
                    colorNum++
                }
                // 设置颜色
                oneWeekCourse.color = color.toInt()
            }
            // 插入数据库
            singleWeekCourseViewModel.addAll(couList)

            LogUtils.d("解析本周、上两周、下两周的周课表 结束")
        }
    }

    override fun onStart() {
        super.onStart()
        LogUtils.d("开始start")
        //是否开启自动检查更新
        checkUpdate()
    }
}
