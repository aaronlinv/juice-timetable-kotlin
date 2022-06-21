package com.juice.timetable.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.datastore.preferences.core.edit
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation.findNavController
import com.dyhdyh.widget.loading.bar.LoadingBar
import com.juice.timetable.INIT_LOGIN_KEY
import com.juice.timetable.R
import com.juice.timetable.data.source.StuInfo
import com.juice.timetable.data.source.local.JuiceDatabase
import com.juice.timetable.dataStore
import com.juice.timetable.databinding.FragmentLoginBinding
import com.juice.timetable.repo.EduRepository
import com.juice.timetable.repo.StuInfoRepository
import com.juice.timetable.utils.CustomLoadingFactory
import com.juice.timetable.utils.ToastyUtils
import com.juice.timetable.viewmodel.AllWeekCourseViewModel
import com.juice.timetable.viewmodel.JuiceViewModelFactory
import com.juice.timetable.viewmodel.SingleWeekCourseViewModel
import com.juice.timetable.viewmodel.StuInfoViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null

    private lateinit var eduRepository: EduRepository;

    private val binding get() = _binding!!
    private lateinit var loadingBar: LoadingBar

    private val stuInfoViewModel: StuInfoViewModel by activityViewModels {
        JuiceViewModelFactory(
            requireActivity().application
        )
    }
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

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        eduRepository = EduRepository()

        // 退出登录，NavController 导航到这里，标识为初次登录
        CoroutineScope(Dispatchers.IO).launch {
            requireActivity().dataStore.edit { settings ->
                settings[INIT_LOGIN_KEY] = true
            }
        }

        with(binding) {
            stuInfoViewModel.stuInfo.observe(viewLifecycleOwner) {
                if (it != null) {
                    etSno.setText(it.stuID.toString())
                    etEduPassword.setText(it.eduPassword)
                }
            }

            btnUserAgreements.setOnClickListener { onDialogClick(btnUserAgreements) }

            btnLogin.setOnClickListener {
                val sno = etSno.text.toString().trim()
                val eduPassword = etEduPassword.text.toString().trim()
                // 如果没有改变则不让用户点按钮
                val prompt = checkSnoAndPasswordIsLegal(sno, eduPassword)
                if (prompt.isNotEmpty()) {
                    ToastyUtils.i(requireActivity(), prompt)
                    return@setOnClickListener
                }

                // 通过校验开始登录
                login(sno, eduPassword)
            }
        }
    }

    /**
     * 账号密码输入合法性校验
     */
    private fun checkSnoAndPasswordIsLegal(sno: String, eduPassword: String): String {
        if (sno.length != 9) return "请输入学号"
        if (!sno.matches(Regex("21\\d{7}"))) return "输入的学号不符合规则"

        if (eduPassword.isEmpty()) return "请输入教务网密码"
        if (eduPassword.length < 6) return "请输入六位及以上的教务网密码"

        return "";
    }

    /**
     * 发送登录请求
     */
    private fun login(sno: String, eduPassword: String) {
        CoroutineScope(Dispatchers.Main).launch {
            // 显示 loading
            showLoading(binding.btnLogin)

            val stuInfo = StuInfo(stuID = sno.toInt(), eduPassword = eduPassword, "")
            try {
                val db = JuiceDatabase.getDatabase(requireActivity())
                val stuInfoRepository = StuInfoRepository(db)

                eduRepository.loginAndUpdateStuInfo(
                    stuInfo,
                    requireActivity(),
                    stuInfoRepository
                )

                ToastyUtils.s(requireActivity(), "登录成功")
            } catch (e: Exception) {
                ToastyUtils.warn(requireActivity(), e.message.toString())
                // 关闭 loading
                loadingBar.cancel()
                return@launch
            }

            // 传入修改前数据库的学号，修改了学号，需要清除周课表避免冲突
            val previousStu: StuInfo? = stuInfoViewModel.stuInfo.value
            if (previousStu != null && sno != previousStu.stuID.toString()) {
                deleteUserAndEmptyCourse()
                stuInfoViewModel.add(stuInfo)
            }

            //关闭 loading
            loadingBar.cancel()

            // 显示 ActionBar
            (activity as AppCompatActivity?)?.supportActionBar?.show()
            // 成功就导航到课表页面
            val navController = findNavController(requireView())
            navController.popBackStack(R.id.nav_home, false);
        }
    }

    /**
     * 更新用户账户密码数据
     */
    private fun deleteUserAndEmptyCourse() {
        CoroutineScope(Dispatchers.IO).launch {
            // 先删除用户信息
            stuInfoViewModel.deleteAll()
            singleWeekCourseViewModel.deleteAll()
            allWeekCourseViewModel.deleteAll()

        }
    }

    /**
     * 对话框的一个实现
     */
    private fun onDialogClick(v: View) {
        AlertDialog.Builder(requireActivity())
            .setTitle("用户条款")
            .setMessage(R.string.user_agreements)
            .setPositiveButton(
                "确定"
            ) { dialog, _ -> dialog.dismiss() }
            .create().show()
    }

    private fun showLoading(v: View) {
        val factory = CustomLoadingFactory()
        factory.setString(getString(R.string.loading))
        loadingBar = LoadingBar.make(v.rootView, factory)
        loadingBar.show()
    }

    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity?)?.supportActionBar?.hide()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}