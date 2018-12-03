package com.example.smartfort.viewpager.adaptor

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.example.smartfort.viewpager.fragment.RecyclerViewTab
import com.example.smartfort.viewpager.fragment.Tab2Fragment
import com.example.smartfort.viewpager.fragment.ScrollingTab

class TabPagerAdapter(fm: FragmentManager, private var tabCount: Int) :
    FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment? {
        return when (position) {
            0 -> RecyclerViewTab()
            1 -> Tab2Fragment()
            2 -> ScrollingTab()
            else -> null
        }
    }

    override fun getCount(): Int {
        return tabCount
    }
}