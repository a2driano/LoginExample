package com.mind.andrew.login.utils.fragments

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager

fun addFragmentToActivity(manager: FragmentManager, fragment: Fragment, idContainer: Int) {
    manager.beginTransaction().add(idContainer, fragment, fragment.javaClass.simpleName).commit()
}