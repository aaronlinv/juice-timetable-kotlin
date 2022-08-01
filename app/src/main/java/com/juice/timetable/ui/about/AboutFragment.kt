package com.juice.timetable.ui.about

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import cn.pedant.SweetAlert.SweetAlertDialog
import com.juice.timetable.R
import com.juice.timetable.api.URI_COOL_APK
import com.juice.timetable.api.URI_EMAIL
import com.juice.timetable.api.URI_GITHUB
import com.juice.timetable.data.parse.ParseVersion
import com.juice.timetable.databinding.FragmentAboutBinding
import com.juice.timetable.utils.LogUtils
import com.juice.timetable.utils.ToastyUtils
import com.juice.timetable.utils.VersionUtils.getVersionCode
import kotlinx.coroutines.*
import java.net.UnknownHostException


class AboutFragment : Fragment() {
    private var _binding: FragmentAboutBinding? = null
    private val binding get() = _binding!!
    private var version: String? = null
    private var description: String? = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAboutBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.tvVersion.text = getVersionCode(requireActivity())

        setOnClickListener()

        return root
    }

    private fun setOnClickListener() {
        binding.checkUpdatesButton.setOnClickListener() {
            checkUpdate()
        }
        binding.tvGithub.setOnClickListener() {
            val uri = Uri.parse(URI_GITHUB)
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }
        binding.tvDeveloper.setOnClickListener() {
            SweetAlertDialog(requireActivity(), SweetAlertDialog.NORMAL_TYPE)
                .setContentText("happy_tree_friends <br><br>PlanB")
                .hideConfirmButton()
                .show()
        }
        binding.tvFeedback.setOnClickListener() {
            joinEmail()
        }
        binding.tvCoolApk.setOnClickListener() {
            val uri = Uri.parse(URI_COOL_APK)
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }
    }

    private fun joinEmail() {
        val uri = Uri.parse(URI_EMAIL)
        val intent = Intent(Intent.ACTION_SENDTO, uri)
        intent.putExtra(Intent.EXTRA_TEXT, "“对于橙汁的意见反馈”<br>") // 正文
        intent.putExtra(Intent.EXTRA_SUBJECT, "我的建议")
        try {
            startActivity(intent)
        } catch (e: java.lang.Exception) {
            ToastyUtils.warn(requireActivity(), "您没有任何邮箱软件")
        }
    }

    private fun checkUpdate() {
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
                    if (e is UnknownHostException) {
                        CoroutineScope(Dispatchers.Main).launch {
                            ToastyUtils.warn(
                                requireActivity(),
                                resources.getString(R.string.error_network)
                            )
                        }

                    }
                    LogUtils.e("获取酷安版本失败")
                    return@withContext
                }
            }

            val currVersion = getVersionCode(requireActivity())
            LogUtils.d("本地 id --> $currVersion")

            // 没网情况下，不允许再执行下面代码
            if (version == null) {
                return@launch
            }

            if (version != currVersion) {
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
                    .show()
            } else {
                ToastyUtils.shortSuccess(requireActivity(), R.drawable.ic_about, "已经是最新版本")
            }
        }
    }

}