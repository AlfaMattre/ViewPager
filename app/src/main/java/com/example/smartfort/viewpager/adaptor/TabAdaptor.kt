package com.example.smartfort.viewpager.adaptor

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.example.smartfort.viewpager.fragment.Tab1Fragment
import com.example.smartfort.viewpager.fragment.Tab2Fragment
import com.example.smartfort.viewpager.fragment.Tab3Fragment

class TabPagerAdapter(fm: FragmentManager, private var tabCount: Int) :
    FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment? {

        when (position) {
            0 -> return Tab1Fragment()
            1 -> return Tab2Fragment()
            2 -> return Tab3Fragment()
            else -> return null
        }
    }

    override fun getCount(): Int {
        return tabCount
    }
}