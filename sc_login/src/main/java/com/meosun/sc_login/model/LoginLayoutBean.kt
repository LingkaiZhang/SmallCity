package com.meosun.sc_login.model

import androidx.databinding.BaseObservable
import com.meosun.sc_login.BR


/**
 * @ClassName LoginLayoutBean
 * @Description TODO
 * @Author Admin
 * @Date 2020/9/21 9:49
 * @Version 1.0
 */
class LoginLayoutBean : BaseObservable() {

    var tips: String = "登录"
        get() {
            field = if (isLogin) {
                "登录"
            } else {
                "注册"
            }
            return field
        }

    var isLogin: Boolean = true
        set(value) {
            if (value == field) {
                return
            }
            field = value
            notifyPropertyChanged(BR._all)
        }

}