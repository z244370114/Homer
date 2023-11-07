package com.demon.apport.ui

import android.content.Intent
import android.net.Uri
import android.os.Environment
import com.demon.apport.App
import com.demon.apport.base.BaseActivity
import com.demon.apport.data.Constants
import com.demon.apport.databinding.ActivitySettingBinding
import com.demon.apport.util.FileUtils
import com.demon.apport.util.get
import com.demon.apport.util.mmkv
import com.demon.qfsolution.utils.getExternalOrFilesDirPath


class SettingActivity : BaseActivity<ActivitySettingBinding>() {

    override fun initData() {
        setToolbar("设置")


        binding.run {
            tvPath.setOnClickListener {
                val intent = Intent(this@SettingActivity, ChangePathActivity::class.java)
                startActivity(intent)
            }
            tvDelete.setOnClickListener {
                val def: String = App.appContext.getExternalOrFilesDirPath(Environment.DIRECTORY_DCIM)
                FileUtils.deleteAll(mmkv.get(Constants.MMKV_STORAGE_PATH, def))
            }
            tvLog.setOnClickListener {
                val intent = Intent(this@SettingActivity, LogListActivity::class.java)
                startActivity(intent)
            }
            tvUserAgreement.setOnClickListener {
                val url = "https://www.freeprivacypolicy.com/live/2db186fb-c5c9-4816-ba00-139bebd2ab06"
                val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                startActivity(browserIntent)
            }
            tvPrivacyAgreement.setOnClickListener {
                val url = "https://www.freeprivacypolicy.com/live/70978041-b643-459a-bec0-e1552e970837"
                val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                startActivity(browserIntent)
            }
        }
    }
}