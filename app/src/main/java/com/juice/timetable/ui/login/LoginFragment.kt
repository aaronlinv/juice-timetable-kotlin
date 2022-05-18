package com.juice.timetable.ui.login

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation.findNavController
import com.dyhdyh.widget.loading.bar.LoadingBar
import com.juice.timetable.R
import com.juice.timetable.data.source.StuInfo
import com.juice.timetable.data.source.local.JuiceDatabase
import com.juice.timetable.databinding.FragmentLoginBinding
import com.juice.timetable.repo.EduRepository
import com.juice.timetable.repo.StuInfoRepository
import com.juice.timetable.utils.CustomLoadingFactory
import com.juice.timetable.utils.ToastyUtils
import com.juice.timetable.viewmodel.StuInfoViewModel
import com.juice.timetable.viewmodel.StuInfoViewModelFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*


class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null

    private val eduRepository = EduRepository()
    private lateinit var stuInfoViewModel: StuInfoViewModel


    private val binding get() = _binding!!
    private lateinit var loadingBar: LoadingBar

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(LoginViewModel::class.java)

        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // val textView: TextView = binding.textHome
        // homeViewModel.text.observe(viewLifecycleOwner) {
        //     textView.text = it
        // }

        val stuInfoViewModelFactory = StuInfoViewModelFactory(requireActivity().application);
        stuInfoViewModel =
            ViewModelProvider(this, stuInfoViewModelFactory)[StuInfoViewModel::class.java]

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            stuInfoViewModel.stuInfo.observe(viewLifecycleOwner) {
                if (it != null) {
                    etSno.setText(it.stuID.toString())
                    etEduPassword.setText(it.eduPassword)
                }
            }

            btnUserAgreements.setOnClickListener { onDialogClick(binding.btnUserAgreements) }

            binding.btnLogin.setOnClickListener {
                val sno = binding.etSno.text.toString().trim()
                val eduPassword = binding.etEduPassword.text.toString().trim()
                // 如果没有改变则不让用户点按钮
                checkLoginInfo(sno, eduPassword)
            }
        }
        // val toolbar = requireActivity().findViewById<Toolbar>(R.id.toolbar)
        // val appBarLayout = requireActivity().findViewById<AppBarLayout>(R.id.appBarLayout)

        // appBarLayout.background  =
        // toolbar
        // println("acctivity --> ${activity.getSu}")


        // binding.textHome.setOnClickListener {
        //     CoroutineScope(Dispatchers.Main).launch {
        //
        //         try {
        //             val queryMap = mapOf("week1" to "8")
        //             val oneWeek = eduRepository.url(URL_ONE_WEEK, queryMap, requireContext());
        //             println(oneWeek)
        //         } catch (e: Exception) {
        //             println(e)
        //         }
        //         // val wholeWeek = eduRepository.wholeWeek()
        //         // println(wholeWeek)
        //     }
        // }
    }

    private fun checkLoginInfo(sno: String, eduPassword: String) {
        val stu: StuInfo? = stuInfoViewModel.getStuInfo()
        if (stu != null) {
            if (sno == stu.stuID.toString() &&
                eduPassword == stu.eduPassword
            ) {
                ToastyUtils.i(requireActivity(), "你还没有修改帐号或密码")
                return
            }
        }

        if (sno.isEmpty()) {
            ToastyUtils.i(requireActivity(), "请输入学号")
        } else {
            if (sno.length != 9) {
                ToastyUtils.i(requireActivity(), "请输入九位数的学号")
            } else if (!sno.matches(Regex("21\\d{7}"))) {
                ToastyUtils.i(requireActivity(), "请输入以21开头的学号")
            } else {
                when {
                    eduPassword.isEmpty() -> ToastyUtils.i(requireActivity(), "请输入教务网密码")
                    eduPassword.length < 6 -> ToastyUtils.i(requireActivity(), "请输入六位及以上的教务网密码")
                    else -> {
                        // 隐藏键盘
                        hideSoftKeyboard(requireActivity())
                        // 禁止登录界面点击
                        binding.btnLogin.isClickable = false
                        // 设置登录按钮和用户条款按钮不可见
                        binding.btnLogin.visibility = View.GONE
                        // loading显示
                        showLoading(binding.btnLogin)
                        // 传入修改前数据库的学号，用于比对，如果修改了学号，需要清除周课表避免冲突
                        login(sno, eduPassword)
                    }
                }
            }
        }
    }

    /**
     * 校验密码
     *
     * @param oldSno
     */
    private fun login(sno: String, eduPassword: String) {
        CoroutineScope(Dispatchers.Main).launch {
            try {
                val stuInfo = StuInfo(stuID = sno.toInt(), eduPassword = eduPassword, "")
                // todo 优化 Repository 实例化
                val db = JuiceDatabase.getDatabase(requireContext())
                val stuInfoRepository = StuInfoRepository(db)
                val wholeWeek = eduRepository.loginAndUpdateStuInfo(
                    stuInfo,
                    requireContext(),
                    stuInfoRepository
                )
                println(wholeWeek)
            } catch (e: Exception) {
                ToastyUtils.c(requireActivity(), e.message.toString())
                // 恢复界面点击
                binding.btnLogin.isClickable = true
                // 关闭loading
                loadingBar.cancel()
                // 设置登录按钮和用户条款按钮可见
                binding.btnLogin.visibility = View.VISIBLE
                return@launch
            }

            // 如果修改了学号，需要清除周课表避免冲突
            // 跳转页面
            //关闭loading
            //关闭loading

            //设置登录按钮和用户条款按钮可见
            //设置登录按钮和用户条款按钮可见
            binding.btnLogin.visibility = View.VISIBLE
            updateUser()

            // 成功就导航到课表页面
            findNavController(requireView()).popBackStack(R.id.nav_login, true)
            // 设置首次登录，刷新数据
            // Constant.REFRESH_DATE = true
        }


        // CoroutineScope(Dispatchers.Main).launch {
        //     var errorStr = ""
        //     LogUtils.i("教务网前端验证成功")
        //     // 避免冲突,删除Cookie
        //     // PreferencesUtils.clear(Constant.PREF_EDU_COOKIE)
        //     // PreferencesUtils.clear(Constant.PREF_LEAVE_COOKIE)
        //     try {
        //         EduInfo.getTimeTable(
        //             mSno,
        //             mEdu,
        //             Constant.URI_CUR_WEEK,
        //             context!!.applicationContext
        //         )
        //     } catch (e: Exception) {
        //         errorStr = e.message
        //         // 网络异常，包装一下
        //         if (errorStr.contains("Unable to resolve host")) {
        //             errorStr = "网络不太好，检查一下网络吧"
        //         }
        //         LogUtils.i("errorText:$errorStr")
        //     }
        //     LogUtils.i("教务网密码验证结束")
        //
        //
        //     // 如果修改了学号，需要清除周课表避免冲突
        //     if (mSno != oldSno) {
        //         mOneWeekCourseViewModel.insertOneWeekCourse()
        //         LogUtils.i("修改了账号 清除数据库所有周课表")
        //     }
        //     LogUtils.i("教务网密码验证结束")
        //     // 跳转到课表首页
        //     val message = Message()
        //     assert(errorStr != null)
        //     if (errorStr.isEmpty()) {
        //         message.what = Constant.MSG_LOGIN_SUCCESS
        //     } else {
        //         message.what = Constant.MSG_LOGIN_FAIL
        //         message.obj = errorStr
        //     }
        //     mHandler.sendMessage(message)
        // }
    }

    /**
     * 更新用户账户密码数据
     */
    private fun updateUser() {
        // // 先删除用户信息
        // mStuInfoViewModel.deleteStuInfo()
        // mAllWeekCourseViewModel.deleteAllWeekCourse()
        // mOneWeekCourseViewModel.deleteOneWeekCourse()
        // //关闭彩虹模式
        // PreferencesUtils.putBoolean(Constant.PREF_RAINBOW_MODE_ENABLED, false)
        // val snoStr: Int = mSno.toInt()
        // val stuInfo1 = StuInfo()
        // stuInfo1.setStuID(snoStr)
        // stuInfo1.setEduPassword(mEdu)
        // mStuInfoViewModel.insertStuInfo(stuInfo1)
    }

    /**
     * 对话框的一个实现
     */
    private fun onDialogClick(v: View) {
        AlertDialog.Builder(requireContext())
            .setTitle("用户条款")
            .setMessage(R.string.user_agreements)
            .setPositiveButton(
                "确定"
            ) { dialog, _ -> dialog.dismiss() }
            .create().show()
    }

    /**
     * 强制隐藏软键盘
     *
     * @param activity
     */
    private fun hideSoftKeyboard(activity: Activity) {
        val imm = (activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager)
        val currentFocus = activity.currentFocus
        currentFocus.let {
            imm.hideSoftInputFromWindow(
                currentFocus?.windowToken,
                0
            )
        }
    }

    private fun showLoading(v: View) {
        val factory = CustomLoadingFactory()
        factory.setString("更新中...")
        loadingBar = LoadingBar.make(v.rootView, factory)
        loadingBar.show()
    }

    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity?)!!.supportActionBar!!.hide()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}