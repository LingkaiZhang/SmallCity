package com.meosun.sc_login.api

import com.topp.lib_net.model.BaseModel
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST


/**
 * @ClassName RequestCenter
 * @Description TODO
 * @Author Admin
 * @Date 2020/9/9 15:30
 * @Version 1.0
 */
interface RequestCenter {

    @POST("/sms-api/v1/message/send_code")
    @FormUrlEncoded
    suspend fun sendSmsVerification(
        @Field("phone") phone: String,
        @Field("equipmentCode") equipmentCode: String
    ): BaseModel<Any>

}