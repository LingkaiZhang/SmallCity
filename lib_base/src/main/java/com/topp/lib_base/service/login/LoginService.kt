package com.topp.lib_base.service.login

import android.content.Context
import androidx.lifecycle.LiveData
import com.alibaba.android.arouter.facade.template.IProvider
import com.topp.lib_base.model.User


/**
 * @ClassName LoginService
 * @Description TODO
 * @Author Admin
 * @Date 2020/9/7 14:28
 * @Version 1.0
 */
interface LoginService : IProvider {

    fun isLogin(): Boolean

    fun start(context: Context): LiveData<User>
}