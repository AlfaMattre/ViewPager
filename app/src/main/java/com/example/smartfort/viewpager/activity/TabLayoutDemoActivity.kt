package com.example.smartfort.viewpager.activity

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.design.widget.TabLayout
import android.support.v7.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_tab_layout_demo.*
import android.view.animation.Animation
import android.view.animation.AnimationSet
import android.view.animation.DecelerateInterpolator
import android.view.animation.ScaleAnimation
import android.view.animation.RotateAnimation
import android.support.v4.content.ContextCompat
import android.view.animation.AccelerateInterpolator
import com.example.smartfort.viewpager.R
import com.example.smartfort.viewpager.adaptor.TabPagerAdapter

class TabLayoutDemoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab_layout_demo)
        setSupportActionBar(toolbar)
        initListeners()
        configureTabLayout()
    }

    private fun initListeners(){
        fab.setOnClickListener { view ->
            Snackbar.make(view, getString(R.string.activity_main_snackbar_message), Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

    private fun configureTabLayout() {
        tab_layout.addTab(tab_layout.newTab().setText("Tab 1 Item"))
        tab_layout.addTab(tab_layout.newTab().setText("Tab 2 Item"))
        tab_layout.addTab(tab_layout.newTab().setText("Tab 3 Item"))

        pager.adapter = TabPagerAdapter(
            supportFragmentManager,
            tab_layout.tabCount
        )
        pager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tab_layout))

        tab_layout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                pager.currentItem = tab.position

                animateFab(tab.position)
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {
            }

            override fun onTabReselected(tab: TabLayout.Tab) {
            }
        })
    }

    @SuppressLint("PrivateResource")
    var colorIntArray = intArrayOf(
        R.color.accent_material_dark,
        R.color.accent_material_light,
        R.color.primary_dark_material_dark
    )
    var iconIntArray = intArrayOf(
        R.drawable.ic_launcher_background,
        R.drawable.ic_launcher_foreground,
        R.drawable.ic_launcher_background
    )

    private fun animateFab(position: Int) {
        fab.clearAnimation()

        val shrink = ScaleAnimation(1f, 0.1f, 1f, 0.1f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f)
        shrink.duration = 100     // animation duration in milliseconds
        shrink.interpolator = AccelerateInterpolator()
        shrink.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation) {
            }

            override fun onAnimationEnd(animation: Animation) {
                fab.backgroundTintList = ContextCompat.getColorStateList(applicationContext, colorIntArray[position])
                fab.setImageDrawable(ContextCompat.getDrawable(applicationContext, iconIntArray[position]))

                val rotate = RotateAnimation(
                    60.0f, 0.0f,
                    Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
                    0.5f
                )
                rotate.duration = 150
                rotate.interpolator = DecelerateInterpolator()

                val expand = ScaleAnimation(
                    0.1f,
                    1f,
                    0.1f,
                    1f,
                    Animation.RELATIVE_TO_SELF,
                    0.5f,
                    Animation.RELATIVE_TO_SELF,
                    0.5f
                )
                expand.duration = 150
                expand.interpolator = DecelerateInterpolator()

                val s = AnimationSet(false) //false means don't share interpolators
                s.addAnimation(rotate)
                s.addAnimation(expand)
                fab.startAnimation(s)
            }

            override fun onAnimationRepeat(animation: Animation) {
            }
        })
        fab.startAnimation(shrink)
    }
}