package com.mind.andrew.login.domain.interactor.login

import com.mind.andrew.login.domain.model.LoginViewModel
import com.mind.andrew.login.domain.model.UserModel

interface DataInteractor {

    fun signIn(model: LoginViewModel): Boolean
    fun register(model: LoginViewModel): Boolean
    fun getData(): List<UserModel>
}