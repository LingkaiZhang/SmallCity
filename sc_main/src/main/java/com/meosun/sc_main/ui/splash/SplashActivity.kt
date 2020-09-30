package com.meosun.sc_main.ui.splash

import android.Manifest
import android.content.Intent
import com.meosun.lib_base.base.BaseActivity
import com.meosun.lib_base.view.DialogUtils
import com.meosun.sc_main.R
import com.meosun.sc_main.databinding.ActivitySplashBinding
import com.meosun.sc_main.ui.MainActivity

import io.reactivex.Observable
import io.reactivex.disposables.Disposable
import pub.devrel.easypermissions.AfterPermissionGranted
import pub.devrel.easypermissions.EasyPermissions
import java.util.concurrent.TimeUnit

class SplashActivity : BaseActivity<SplashViewModel, ActivitySplashBinding>(),
    EasyPermissions.PermissionCallbacks {


    private var disposable: Disposable? = null
    private val tips = "玩安卓现在要向您申请权限，用于更好的使用体验，您也可以在设置中手动开启或者取消。"
    private  val perms = arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.ACCESS_FINE_LOCATION,
        Manifest.permission.READ_LOGS, Manifest.permission.READ_PHONE_STATE,
        Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.SET_DEBUG_APP,
        Manifest.permission.RECEIVE_SMS, Manifest.permission.SYSTEM_ALERT_WINDOW,Manifest.permission.CAMERA,
        Manifest.permission.WRITE_APN_SETTINGS,Manifest.permission.RECORD_AUDIO)


    companion object {
        private const val WRITE_EXTERNAL_STORAGE = 100
    }

    override fun initData() {

    }

    override fun initView() {
        requestPermission()
    }

    override fun getLayoutResId(): Int {
        return R.layout.activity_splash
    }

    /**
     * 申请权限
     */
    private fun requestPermission() {
        //已申请
        if (EasyPermissions.hasPermissions(this, *perms)) {
            startIntent()
        } else {
            //为申请，显示申请提示语
            DialogUtils.tips(this, tips) {
                RequestLocationAndCallPermission()
            }
        }
    }

    @AfterPermissionGranted(WRITE_EXTERNAL_STORAGE)
    private fun RequestLocationAndCallPermission() {
        //数组中权限都已申请
        if (EasyPermissions.hasPermissions(this, *perms)) {
            startIntent()
        } else {
            EasyPermissions.requestPermissions(this, "请求写入权限", WRITE_EXTERNAL_STORAGE, *perms)
        }
    }

    /**
     * 开始倒计时跳转
     */
    private fun startIntent() {
        //开启服务
        //startService(Intent(this,PlayService::class.java))
        disposable = Observable.timer(2000, TimeUnit.MILLISECONDS)
            .subscribe {
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }
    }

    override fun onDestroy() {
        super.onDestroy()
        disposable?.dispose()
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this)
    }

    /**
     * 权限申请失败
     */
    override fun onPermissionsDenied(requestCode: Int, perms: MutableList<String>) {
    }

    /**
     * 权限申请成功
     */
    override fun onPermissionsGranted(requestCode: Int, perms: List<String>) {
        startIntent()
    }
}