package com.topp.sc_login.ui


import android.widget.Toast
import com.topp.lib_base.base.BaseActivity
import com.topp.lib_base.utils.DeviceIdUtil
import com.win.ft_login.R
import com.win.ft_login.databinding.ActivityLoginBinding
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity<LoginViewModel, ActivityLoginBinding>() {

    override fun initData() {

    }

    override fun initView() {
        titleBar.setBackImageRes(R.mipmap.back)
        titleBar.backLayout.setOnClickListener {
            finish()
        }

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
