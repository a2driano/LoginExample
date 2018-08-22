package com.mind.andrew.login.presentation.login

import android.content.Context
import com.mind.andrew.login.R
import com.mind.andrew.login.domain.interactor.login.LoginInteractor
import com.mind.andrew.login.domain.interactor.login.LoginInteractorImpl
import com.mind.andrew.login.domain.model.LoginViewModel

class LoginPresenter(
        val view: LoginContract.LoginView, val context: Context?) :
        LoginContract.LoginPresenter {

    private val loginInteractor: LoginInteractor = LoginInteractorImpl.instance

    override fun signIn(model: LoginViewModel) {
        val response = loginInteractor.signIn(model)
        if (context == null) return
        if (response)
            view.successLogin(context.getString(R.string.sign_in_success))
        else
            view.errorLogin(context.getString(R.string.error_sign_in))
    }

    override fun signUp(model: LoginViewModel) {
        val response = loginInteractor.register(model)
        if (context == null) return
        if (response)
            view.successLogin(context.getString(R.string.register_success))
        else
            view.errorLogin(context.getString(R.string.error_register))
    }

    override fun signUpState() {
//        view.toggleSignView()
    }

}