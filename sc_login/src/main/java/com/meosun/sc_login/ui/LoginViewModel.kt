package com.meosun.sc_login.ui

import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.meosun.lib_base.utils.BaseContext
import com.win.lib_net.model.NetResult
import kotlinx.coroutines.launch


/**
 * @ClassName LoginViewModel
 * @Description TODO
 * @Author Admin
 * @Date 2020/9/7 16:28
 * @Version 1.0
 */
class LoginViewModel(private val loginRepo: LoginRepository) : ViewModel() {

    fun sendSmsVerification(phoneNo: String, deviceId: String?) {

        viewModelScope.launch {
            val sendSmsCode = loginRepo.sendSmsVerification(phoneNo, deviceId)

            if (sendSmsCode is NetResult.Success) {
                Toast.makeText(
                    BaseContext.instance.getContext(),
                    "发送短信成功",
                    Toast.LENGTH_LONG
                ).show()
            } else if (sendSmsCode is NetResult.Error) {
                if (sendSmsCode.exception.errCode.equals("send_error")){
                    Toast.makeText(
                        BaseContext.instance.getContext(),
                        sendSmsCode.exception.msg,
                        Toast.LENGTH_LONG
                    ).show()
                }



            }

        }
    }
}