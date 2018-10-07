package com.mind.andrew.login.presentation.login

import android.support.v4.app.FragmentActivity

interface LoginContract {
    interface View {
        fun successLogin(msg: String)
        fun errorLogin(msg: String)
        fun parentActivity(): FragmentActivity?
//        fun toggleSignView()
    }

    interface Presenter {
        fun signIn(model: LoginViewModel)
        fun signUp(model: LoginViewModel)
    }
}