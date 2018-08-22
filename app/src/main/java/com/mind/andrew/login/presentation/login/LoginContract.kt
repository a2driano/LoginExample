package com.mind.andrew.login.presentation.login

import com.mind.andrew.login.domain.model.LoginViewModel

interface LoginContract {
    interface LoginView {
        fun successLogin(msg: String)
        fun errorLogin(msg: String)
//        fun toggleSignView()
    }

    interface LoginPresenter {
        fun signUpState()
        fun signIn(model: LoginViewModel)
        fun signUp(model: LoginViewModel)
    }
}