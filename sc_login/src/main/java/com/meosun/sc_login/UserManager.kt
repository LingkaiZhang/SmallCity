package com.meosun.sc_login

import android.content.Context
import android.content.Intent
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.meosun.lib_base.model.User
import com.meosun.sc_login.ui.LoginActivity
import com.tencent.mmkv.MMKV


/**
 * @ClassName UserManager
 * @Description TODO
 * @Author Admin
 * @Date 2020/9/7 14:39
 * @Version 1.0
 */
object UserManager {

    private const val USER_DATA: String = "user_data"
    private var mmkv: MMKV = MMKV.defaultMMKV()

    private val liveData = MutableLiveData<User>()

    fun isLogin(): Boolean {
        return getUser() != null
    }

    private fun getUser(): User? {
        return mmkv.decodeParcelable(USER_DATA, User::class.java)
    }

    fun start(context: Context): LiveData<User> {
        context.startActivity(Intent(context, LoginActivity::class.java))
        return liveData
    }
}