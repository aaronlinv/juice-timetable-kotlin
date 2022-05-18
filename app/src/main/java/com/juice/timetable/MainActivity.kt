package com.juice.timetable

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView
import com.juice.timetable.data.source.local.JuiceDatabase
import com.juice.timetable.databinding.ActivityMainBinding
import com.juice.timetable.viewmodel.StuInfoViewModel
import com.juice.timetable.viewmodel.StuInfoViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    // private val MainActivity.viewModelProvider: ViewModelProvider
    //     get() = ViewModelProvider(this)
    //
    // private val MainActivity.mainViewModel1: MainViewModel
    //     get() = ViewModelProvider(this).get(MainViewModel::class.java)

    private lateinit var stuInfoViewModel: StuInfoViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarMain.toolbar)

        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

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

        val myViewModelFactory = StuInfoViewModelFactory(application)
        stuInfoViewModel =
            ViewModelProvider(this, myViewModelFactory)[StuInfoViewModel::class.java]
        val stuInfo = stuInfoViewModel.stuInfo.observe(
            this
        ) {
            println("stuInfo --> $it")
            if (it != null) {
                // navController.navigate(R.id.action_nav_home_to_nav_login)
                findNavController(
                    this,
                    R.id.nav_host_fragment_content_main
                ).navigate(R.id.action_nav_home_to_nav_login)
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    override fun onDestroy() {
        super.onDestroy()
        // 关闭数据库
        JuiceDatabase.getDatabase(this).close()
    }
}