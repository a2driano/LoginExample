package com.mind.andrew.login.domain.interactor.login

import com.mind.andrew.login.data.DataManager
import com.mind.andrew.login.data.DataManagerImpl
import com.mind.andrew.login.domain.model.LoginViewModel

class LoginInteractorImpl : LoginInteractor {

    private object Holder {
        val INSTANCE = LoginInteractorImpl()
    }

    companion object {
        val instance: LoginInteractor by lazy { Holder.INSTANCE }
    }

    private val dataManager: DataManager = DataManagerImpl.instance

    override fun signIn(model: LoginViewModel): Boolean {
        val modelDevice: LoginViewModel = dataManager.getLoginData()
        return model.login == modelDevice.login && model.password == modelDevice.password
    }

    override fun register(model: LoginViewModel): Boolean {
        val modelDevice: LoginViewModel = dataManager.getLoginData()
        return model.login != modelDevice.login
    }
}