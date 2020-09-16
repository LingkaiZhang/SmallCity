package com.meosun.sc_main

import android.os.Handler
import android.view.View
import androidx.fragment.app.Fragment
import com.meosun.sc_main.R
import com.next.easynavigation.view.EasyNavigationBar
import com.next.easynavigation.view.EasyNavigationBar.OnTabClickListener
import com.meosun.lib_base.base.BaseFragment
import com.meosun.sc_main.databinding.FragmentMainBinding

import com.meosun.sc_main.ui.normal.*
import kotlinx.android.synthetic.main.fragment_main.*


/**
 * A simple [Fragment] subclass.
 * Use the [MainFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MainFragment : BaseFragment<MainFragmentViewModel, FragmentMainBinding>() {

    private val tabText = listOf("首页", "发现", "消息", "我的")

    //未选中icon
    private val normalIcon = listOf(R.mipmap.index, R.mipmap.find, R.mipmap.message, R.mipmap.me)

    //选中时icon
    private val selectIcon =
        listOf(R.mipmap.index1, R.mipmap.find1, R.mipmap.message1, R.mipmap.me1)

    private val fragmentList = arrayListOf<Fragment>()

    private var flag = true

    override fun getLayoutResId(): Int = R.layout.fragment_main

    override fun initData() {
        fragmentList.add(AFragment())
        fragmentList.add(BFragment())
        fragmentList.add(CFragment())
        fragmentList.add(DFragment())
        fragmentList.add(MineFragment())

        navigationBar.titleItems(tabText.toTypedArray())
            .normalIconItems(normalIcon.toIntArray())
            .selectIconItems(selectIcon.toIntArray())
            .fragmentList(fragmentList)
            .centerImageRes(R.mipmap.add_image)
            .centerTextStr("发布")
            .centerLayoutRule(EasyNavigationBar.RULE_BOTTOM)
            .centerLayoutBottomMargin(0)
            .centerAlignBottom(true)
            .centerAsFragment(true)
            .fragmentManager(activity?.supportFragmentManager)
            .setOnTabClickListener(object : EasyNavigationBar.OnTabClickListener {
                override fun onTabSelectEvent(view: View?, position: Int): Boolean {
                    return false
                }

                override fun onTabReSelectEvent(view: View?, position: Int): Boolean {
                    return false
                }

            })
            .setOnCenterTabClickListener {
                Handler().post(Runnable() {
                    //＋ 旋转动画
                    if (flag) {
                        navigationBar.centerImage.animate().rotation(45F).duration = 400;
                    } else {
                        navigationBar.centerImage.animate().rotation(0F).duration = 400;
                    }
                    flag = !flag
                })
                false
            }
            .canScroll(true)
            .mode(EasyNavigationBar.NavigationMode.MODE_ADD)
            .build();

    }

    override fun initView() {
    }

}