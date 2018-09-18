package com.mind.andrew.login.presentation.login

import com.mind.andrew.login.R
import com.mind.andrew.login.domain.interactor.login.DataInteractor
import com.mind.andrew.login.domain.interactor.login.DataInteractorImpl
import com.mind.andrew.login.domain.model.LoginViewModel
import com.mind.andrew.login.presentation.list.ListFragment
import com.mind.andrew.login.utils.fragments.addFragmentToActivity

class LoginPresenter(
        val view: LoginContract.View) :
        LoginContract.Presenter {

//    companion object {
//        private val dataInteractor: DataInteractor = DataInteractorImpl
//    }

    private val dataInteractor: DataInteractor = DataInteractorImpl

    override fun signIn(model: LoginViewModel) {
        val response = dataInteractor.signIn(model)
        if (response) {
            view.successLogin(view.parentActivity()!!.baseContext.getString(R.string.sign_in_success))
            openNextScreen()
        } else
            view.errorLogin(view.parentActivity()!!.getString(R.string.error_sign_in))
    }

    override fun signUp(model: LoginViewModel) {
        val response = dataInteractor.register(model)
        if (response) {
            view.successLogin(view.parentActivity()!!.getString(R.string.register_success))
            openNextScreen()
        } else
            view.errorLogin(view.parentActivity()!!.getString(R.string.error_register))
    }

    private fun openNextScreen() {
        addFragmentToActivity(view.parentActivity()!!.supportFragmentManager, ListFragment.newInstance(), R.id.container)
    }
}