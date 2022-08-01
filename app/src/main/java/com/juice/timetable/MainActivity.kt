package com.juice.timetable

import android.content.Context
import android.os.Bundle
import android.view.Menu
import android.widget.ImageView
import androidx.activity.viewModels
import androidx.core.view.GravityCompat
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.*
import cn.pedant.SweetAlert.SweetAlertDialog
import com.google.android.material.navigation.NavigationView
import com.juice.timetable.databinding.ActivityMainBinding
import com.juice.timetable.ui.course.CourseFragment
import com.juice.timetable.utils.LogUtils
import com.juice.timetable.utils.ToastyUtils
import com.juice.timetable.viewmodel.AllWeekCourseViewModel
import com.juice.timetable.viewmodel.JuiceViewModelFactory
import com.juice.timetable.viewmodel.SingleWeekCourseViewModel
import com.juice.timetable.viewmodel.StuInfoViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

// At the top level of your kotlin file:
val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

/**
 * 首次登录
 */
val INIT_LOGIN_KEY = booleanPreferencesKey("init_login_key")

/**
 * 当前周
 */
val CUR_WEEK_KEY = intPreferencesKey("cur_week_key")

/**
 * 彩虹模式随机数
 */
val RAINBOW_MODE_NUM = intPreferencesKey("rainbow_mode_num")

/**
 * 当前学期
 */
val CUR_SEMESTER = stringPreferencesKey("cur_semester")

/**
 * 第一周周一日期
 */
val FIRST_WEEK_MON_KEY = stringPreferencesKey("first_week_mon_key")

/**
 * 是否开启慕课
 */
val ENABLE_SHOW_MOOC = booleanPreferencesKey("enable_show_mooc")

/**
 * 是否开启彩虹模式
 */
val ENABLE_RAINBOW_MODE = booleanPreferencesKey("enable_rainbow_mode")

/**
 * 是否检查版本
 */
val ENABLE_CHECK_VERSION = booleanPreferencesKey("enable_check_version")

/**
 * 最后一次检查更新的日期
 */
val LAST_CHECK_VERSION_DATE = stringPreferencesKey("last_check_version_date")

class MainActivity : BaseActivity() {
    // 伴生对象，类似 Java 静态成员变量
    companion object {
        /**
         * 打开应用首次刷新课表
         */
        var refreshDate = true
    }

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    private lateinit var navHostFragment: NavHostFragment

    // private val MainActivity.viewModelProvider: ViewModelProvider
    //     get() = ViewModelProvider(this)
    //
    // private val MainActivity.mainViewModel1: MainViewModel
    //     get() = ViewModelProvider(this).get(MainViewModel::class.java)

    // private lateinit var stuInfoViewModel: StuInfoViewModel


    // val stuInfoViewModel by viewModels<StuInfoViewModel>()
    // 初始化 ViewModel 的一种方式
    // https://developer.android.com/topic/libraries/architecture/viewmodel#sharing
    // https://stackoverflow.com/a/67811504/19141665
    private val stuInfoViewModel: StuInfoViewModel by viewModels {
        JuiceViewModelFactory(
            application
        )
    }
    private val singleWeekCourseViewModel: SingleWeekCourseViewModel by viewModels {
        JuiceViewModelFactory(
            application
        )
    }
    private val allWeekCourseViewModel: AllWeekCourseViewModel by viewModels {
        JuiceViewModelFactory(
            application
        )
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var toolbar = binding.appBarMain.toolbar
        setSupportActionBar(binding.appBarMain.toolbar)

        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        // 解决 CourseFragment 获取 Toolbar：layout/content_main: Error inflating class fragment
        // https://stackoverflow.com/a/70621838
        navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment_content_main) as NavHostFragment
        navController = navHostFragment.navController
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_about
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        // 重写抽屉点击事件
        // Navigation drawer item click listener not working
        // https://stackoverflow.com/a/58681944
        navView.setNavigationItemSelectedListener {

            val id: Int = it.getItemId()
            if (id == R.id.nav_logout) {
                // 确认提示，是否登出
                SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE)
                    .setTitleText("退出登录")
                    .setContentText("确认退出当前的账号，并清除所有课程数据？")
                    .setCancelText("取消")
                    .setConfirmText("确认")
                    .setConfirmClickListener { sDialog ->
                        sDialog.dismissWithAnimation()
                        supportActionBar?.hide()
                        // navController.popBackStack(R.id.nav_home, true);
                        navController.navigate(R.id.nav_login);
                        // 清空课程数据
                        CoroutineScope(Dispatchers.IO).launch {
                            singleWeekCourseViewModel.deleteAll()
                            allWeekCourseViewModel.deleteAll()

                        }
                    }
                    .showCancelButton(true)
                    .setCancelClickListener { sDialog -> sDialog.cancel() }
                    .show()

                drawerLayout.closeDrawer(GravityCompat.START)
                return@setNavigationItemSelectedListener false
            }

            // This is for maintaining the behavior of the Navigation view
            NavigationUI.onNavDestinationSelected(it, navController)
            // This is for closing the drawer after acting on it
            drawerLayout.closeDrawer(GravityCompat.START)

            return@setNavigationItemSelectedListener true
        }

        // val database = JuiceDatabase.getDatabase(this)
        // val stuInfoRepository = StuInfoRepository(database)
        //
        //
        // CoroutineScope(Dispatchers.Main).launch {
        //     val stu = stuInfoRepository.get()
        //     LogUtils.i("stu --> $stu")
        //     if (stu != null) {
        //         navController.navigate(R.id.action_nav_home_to_nav_login)
        //     }
        // }
        // navController.navigate(R.id.nav_login)

        // val myViewModelFactory = StuInfoViewModelFactory(application)
        // stuInfoViewModel =
        //     ViewModelProvider(this, myViewModelFactory)[StuInfoViewModel::class.java]
        // val stuInfo = stuInfoViewModel.stuInfo.observe(
        //     this
        // ) {
        //     println("stuInfo --> $it")
        //     // if (it != null) {
        //     //     navController.navigate(R.id.nav_login)
        //     // }
        // }

        // 预加载 dataStore https://developer.android.com/topic/libraries/architecture/datastore


        runBlocking {
            val initLogin = dataStore.data.map {
                it[INIT_LOGIN_KEY] ?: true
            }.firstOrNull()

            if (initLogin == true) {
                navController.navigate(R.id.nav_login)
            }
        }

        // 侧边栏橙汁图标
        val juiceIcon: ImageView =
            navView.getHeaderView(0).findViewById<ImageView>(R.id.imageView)


        // 单击开启/关闭 彩虹模式
        juiceIcon.setOnClickListener {
            var enableRainbowMode = false
            runBlocking {
                dataStore.data.map {
                    enableRainbowMode = it[ENABLE_RAINBOW_MODE] ?: false
                }.firstOrNull()
            }

            // 反转设置
            // 如果现在是开启就关闭
            var toastStr = "开启彩虹模式"
            if (enableRainbowMode) {
                toastStr = "关闭彩虹模式"
            }
            enableRainbowMode = !enableRainbowMode
            CourseFragment.enableRainbowMode = enableRainbowMode

            runBlocking {
                dataStore.edit { settings ->
                    settings[ENABLE_RAINBOW_MODE] = enableRainbowMode
                }
                LogUtils.d("dataStore 设置是否开启彩虹模式：${enableRainbowMode}")
            }

            ToastyUtils.i(this, toastStr)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        // menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment_content_main) as NavHostFragment
        val navController = navHostFragment.navController
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    override fun onDestroy() {
        super.onDestroy()
        // 关闭数据库
        // JuiceDatabase.close()
        // 关闭数据库会导致，返回桌面，然后再进入，数据库写入报错闪退
    }

    /**
     * 抽屉打开的时候，点击返回，关闭抽屉
     */
    override fun onBackPressed() {
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        } else if (navController.currentDestination?.label == resources.getString(R.string.menu_login)) {
            // todo 判断逻辑待优化
            // 登录页面返回即退出
            finish()
        } else {
            super.onBackPressed()
        }
    }
}