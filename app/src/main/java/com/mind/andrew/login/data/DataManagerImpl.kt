package com.mind.andrew.login.data

import com.mind.andrew.login.App
import com.mind.andrew.login.domain.model.LoginViewModel

class DataManagerImpl private constructor() : DataManager {


    private val login: String = App.login
    private val pass: String = App.password

    private object Holder {
        val INSTANCE = DataManagerImpl()
    }

    companion object {
        val instance: DataManager by lazy { Holder.INSTANCE }
    }

    override fun getLoginData(): LoginViewModel {
        return LoginViewModel(login, pass, "")
    }
}