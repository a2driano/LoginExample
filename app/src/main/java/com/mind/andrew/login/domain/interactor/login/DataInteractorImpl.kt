package com.mind.andrew.login.domain.interactor.login

import com.mind.andrew.login.data.DataManager
import com.mind.andrew.login.data.DataManagerImpl
import com.mind.andrew.login.presentation.login.LoginViewModel
import com.mind.andrew.login.domain.model.UserModel

object DataInteractorImpl : DataInteractor {
    private val dataManager: DataManager = DataManagerImpl

    override fun signIn(model: LoginViewModel): Boolean {
        return dataManager.getLoginData(UserModel(login = model.login, password = model.password))
    }

    override fun register(model: LoginViewModel): Boolean {
        return dataManager.saveData(UserModel(login = model.login, password = model.password))
    }

    override fun getData(): List<UserModel> {
        return dataManager.getData()
    }
}
