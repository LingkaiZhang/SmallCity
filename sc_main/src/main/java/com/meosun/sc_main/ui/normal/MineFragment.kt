package com.meosun.sc_main.ui.normal

import com.meosun.lib_base.base.BaseFragment
import com.meosun.lib_base.service.login.warp.LoginServiceImplWrap
import com.meosun.sc_main.R
import com.meosun.sc_main.databinding.FragmentMineBinding

import kotlinx.android.synthetic.main.fragment_mine.*


/**
 * @ClassName MineFragment
 * @Description TODO
 * @Author Admin
 * @Date 2020/9/7 14:00
 * @Version 1.0
 */
class MineFragment : BaseFragment<MineFragmentViewModel, FragmentMineBinding>() {

    override fun getLayoutResId(): Int = R.layout.fragment_mine

    override fun initData() {

    }

    override fun initView() {
        mViewBinding.btnLoginRegister.setOnClickListener {
            if (!LoginServiceImplWrap.isLogin()){
                LoginServiceImplWrap.start(requireContext())
            }
        }
    }
}