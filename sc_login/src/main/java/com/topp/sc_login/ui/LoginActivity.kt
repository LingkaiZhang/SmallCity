package com.topp.sc_login.ui


import com.topp.lib_base.base.BaseActivity
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
    }

    override fun getLayoutResId(): Int {
        return R.layout.activity_login
    }
}
