package com.topp.sc_login.ui

import com.topp.lib_net.net.BaseRepository
import com.topp.lib_net.net.RetrofitClient
import com.topp.sc_login.api.RequestCenter
import com.win.lib_net.model.NetResult


/**
 * @ClassName LoginRepository
 * @Description TODO
 * @Author Admin
 * @Date 2020/9/9 14:11
 * @Version 1.0
 */
class LoginRepository(private val service: RetrofitClient) : BaseRepository() {
    suspend fun sendSmsVerification(phoneNo: String, deviceId: String?): NetResult<Any> {
        return callRequest(call = { requestSendSmsVerification(phoneNo, deviceId) })
    }

    private suspend fun requestSendSmsVerification(
        phoneNo: String,
        deviceId: String?
    ): NetResult<Any> {
        return handleResponse(
            service.create(RequestCenter::class.java).sendSmsVerification(
                phoneNo,
                deviceId.toString()
            )
        )
    }

}