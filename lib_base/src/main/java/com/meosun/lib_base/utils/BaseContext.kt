package com.meosun.lib_base.utils

import android.content.Context


/**
 * @ClassName BaseContext
 * @Description TODO
 * @Author Admin
 * @Date 2020/9/2 10:48
 * @Version 1.0
 */
class BaseContext private constructor() {

    private lateinit var mContext: Context

    fun init(context: Context) {
        mContext = context
    }

    fun getContext(): Context {
        return mContext
    }

    companion object {

        val instance = Singleton.holder

        object Singleton {
            val holder = BaseContext()
        }
    }

}