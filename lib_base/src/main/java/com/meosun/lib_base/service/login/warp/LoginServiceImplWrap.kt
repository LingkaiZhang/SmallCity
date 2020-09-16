package com.meosun.lib_base.service.login.warp

import android.content.Context
import androidx.lifecycle.LiveData
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.launcher.ARouter
import com.meosun.lib_base.model.User
import com.meosun.lib_base.service.ConstantsPath
import com.meosun.lib_base.service.login.LoginService



/**
 * @ClassName LoginServiceImplWrap
 * @Description TODO
 * @Author Admin
 * @Date 2020/9/7 14:29
 * @Version 1.0
 */
object LoginServiceImplWrap {

    @Autowired(name = ConstantsPath.LOGIN_SERVICE_PATH)
    lateinit var service: LoginService

    init {
        ARouter.getInstance().inject(this)
    }

    fun isLogin(): Boolean {
        return service.isLogin()
    }

    fun start(context: Context): LiveData<User> {
        return service.start(context)
    }

}