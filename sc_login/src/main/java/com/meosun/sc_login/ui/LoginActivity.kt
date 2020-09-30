package com.meosun.sc_login.ui


import android.util.Log
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.meosun.sc_login.databinding.ActivityLoginBinding

import com.meosun.lib_base.base.BaseActivity
import com.meosun.lib_base.utils.DeviceIdUtil
import com.meosun.sc_login.R
import com.meosun.sc_login.model.LoginLayoutBean
import com.umeng.socialize.UMAuthListener
import com.umeng.socialize.UMShareAPI
import com.umeng.socialize.bean.SHARE_MEDIA
import kotlinx.android.synthetic.main.activity_login.*


class LoginActivity : BaseActivity<LoginViewModel, ActivityLoginBinding>() {

    /**
     * 第三方登录回调
     */
    internal var authListener: UMAuthListener = object : UMAuthListener {

        /**
         * 开始登录的回调
         * @param platform 第三方登录的平台名称
         */
        override fun onStart(platform: SHARE_MEDIA) {
            Log.d("ShareSDK","登录的第三方平台是:" + platform)
        }

        /**
         * 登录成功回调
         * @param platform
         * @param action
         * @param map
         */
        override fun onComplete(platform: SHARE_MEDIA, action: Int, map: Map<String, String>) {
            //  遍历map集合，取出QQ登录后回调给我们的信息
            for (key in map.keys) {
                Log.d("ShareSDK","key值是：" + key + "  对应的具体值:" + map[key] + "\n")
            //将取出的QQ账户信息存储到SharedPreferences中

            }
            Log.d("ShareSDK","登录")
        }

        /**
         * 失败
         * @param platform
         * @param action
         * @param t
         */
        override fun onError(platform: SHARE_MEDIA, action: Int, t: Throwable) {
            Log.d("ShareSDK","登录失败" + t.message)
        }

        /**
         * 取消登录的回调
         * @param platform
         * @param action
         */
        override fun onCancel(platform: SHARE_MEDIA, action: Int) {
            Log.d("ShareSDK","取消登录")
        }
    }

    private lateinit var mData: LoginLayoutBean

    override fun initData() {
        mData = LoginLayoutBean()
        mViewBinding.bean = mData
    }

    override fun initView() {
        initListener()
    }

    private fun initListener() {
        //验证码
        countDownTextView.setOnClickListener {
            val phoneNo = etPhone.text.toString().trim()
            if (phoneNo.isNotEmpty() && phoneNo.length == 11) {
                mViewModel.sendSmsVerification(phoneNo, DeviceIdUtil.getDeviceId(this))
            } else {
                Toast.makeText(this, "请输入正确的手机号", Toast.LENGTH_SHORT).show()
                etPhone.requestFocus()
                countDownTextView.reset()
            }
        }
        ivWeChat.setOnClickListener {
            UMShareAPI.get(this).getPlatformInfo(this, SHARE_MEDIA.WEIXIN, authListener)
        }

        //切换登录注册
        mViewBinding.btnLoginTips.setOnClickListener {
            mData.isLogin = true
            mViewBinding.btnLoginTips.setTextColor(ContextCompat.getColor(this,R.color.black))
            mViewBinding.btnRegisterTips.setTextColor(ContextCompat.getColor(this,R.color.text_gray_46))
        }
        mViewBinding.btnRegisterTips.setOnClickListener {
            mData.isLogin = false
            mViewBinding.btnRegisterTips.setTextColor(ContextCompat.getColor(this,R.color.black))
            mViewBinding.btnLoginTips.setTextColor(ContextCompat.getColor(this,R.color.text_gray_46))
        }

        //登录或注册
        mViewBinding.btnNextStep.setOnClickListener {
            if (mData.isLogin){

            } else {

            }
        }

    }

    override fun getLayoutResId(): Int {
        return R.layout.activity_login
    }
}
