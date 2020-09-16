package com.meosun.sc_login.ui


import android.widget.Toast
import com.meosun.sc_login.databinding.ActivityLoginBinding

import com.meosun.lib_base.base.BaseActivity
import com.meosun.lib_base.utils.DeviceIdUtil
import com.meosun.sc_login.R
import kotlinx.android.synthetic.main.activity_login.*


class LoginActivity : BaseActivity<LoginViewModel, ActivityLoginBinding>() {

    override fun initData() {

    }

    override fun initView() {
        initListener()
    }

    private fun initListener() {
        //验证码
        countDownTextView.setOnClickListener {
            val phoneNo = etPhone.text.toString().trim()
            if (phoneNo.isNotEmpty() && phoneNo.length == 11) {
                mViewModel.sendSmsVerification(phoneNo, DeviceIdUtil.getDeviceId(this))
            } else {
                Toast.makeText(this, "请输入正确的手机号", Toast.LENGTH_SHORT).show()
                etPhone.requestFocus()
                countDownTextView.reset()
            }

        }
    }

    override fun getLayoutResId(): Int {
        return R.layout.activity_login
    }
}
