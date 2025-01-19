package com.example.viewpagerapp

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class MyPagerAdapter(fm : FragmentManager , lc : Lifecycle)
    : FragmentStateAdapter(fm, lc) {

        var fragArray : ArrayList<Fragment> = ArrayList()

    fun addFragementToList(fragment: Fragment){
        fragArray.add(fragment)
    }
    override fun getItemCount(): Int {
        return  fragArray.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragArray.get(position)
    }
}