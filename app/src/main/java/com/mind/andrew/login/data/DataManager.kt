package com.mind.andrew.login.data

import com.mind.andrew.login.domain.model.LoginViewModel
import com.mind.andrew.login.domain.model.UserModel

interface DataManager {
    fun getLoginData(model: UserModel): Boolean
    fun saveData(user: UserModel): Boolean
    fun getData(): List<UserModel>
}