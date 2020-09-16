package com.meosun.sc_webview.service

import android.content.Context
import com.alibaba.android.arouter.facade.annotation.Route
import com.meosun.lib_base.service.ConstantsPath
import com.meosun.lib_base.service.webview.WebViewService
import com.meosun.sc_webview.WebViewActivity


/**
 * @ClassName WebViewServiceImpl
 * @Description TODO
 * @Author Admin
 * @Date 2020/9/14 17:37
 * @Version 1.0
 */
@Route(path = ConstantsPath.WEB_VIEW_SERVICE_PATH)
class WebViewServiceImpl : WebViewService {
    override fun start(context: Context, title: String, url: String) {
        WebViewActivity.start(context, title, url)
    }

    override fun init(context: Context?) {
    }
}