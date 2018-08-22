package com.mind.andrew.login.utils.pager

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.mind.andrew.login.presentation.login.FragmentSignIn
import com.mind.andrew.login.presentation.login.FragmentSignUp

class LoginPagerAdapter(fm: FragmentManager?) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> FragmentSignIn.newInstance()
            else -> FragmentSignUp.newInstance()
        }
    }

    override fun getCount(): Int {
        return 2
    }

}