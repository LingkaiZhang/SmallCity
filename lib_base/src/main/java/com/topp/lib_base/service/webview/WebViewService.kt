package com.topp.lib_base.service.webview

import android.content.Context
import com.alibaba.android.arouter.facade.template.IProvider


/**
 * @ClassName WebViewService
 * @Description TODO
 * @Author Admin
 * @Date 2020/9/14 15:20
 * @Version 1.0
 */
interface WebViewService : IProvider {
    fun start(context: Context, title: String, url: String)
}