package com.topp.sc_login.service

import android.content.Context
import androidx.lifecycle.LiveData
import com.alibaba.android.arouter.facade.annotation.Route
import com.topp.lib_base.model.User
import com.topp.lib_base.service.ConstantsPath
import com.topp.lib_base.service.login.LoginService
import com.topp.sc_login.UserManager


/**
 * @ClassName LoginServiceImpl
 * @Description TODO
 * @Author Admin
 * @Date 2020/9/7 15:16
 * @Version 1.0
 */
@Route(path = ConstantsPath.LOGIN_SERVICE_PATH)
class LoginServiceImpl : LoginService {

    override fun isLogin(): Boolean {
        return UserManager.isLogin()
    }

    override fun start(context: Context): LiveData<User> {
        return UserManager.start(context)
    }

    override fun init(context: Context?) {
    }

}