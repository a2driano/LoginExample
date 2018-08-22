package com.mind.andrew.login.domain.interactor.login

import com.mind.andrew.login.domain.model.LoginViewModel

interface LoginInteractor {

    fun signIn(model: LoginViewModel): Boolean
    fun register(model: LoginViewModel): Boolean
}