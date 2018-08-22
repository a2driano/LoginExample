package com.mind.andrew.login.data

import com.mind.andrew.login.domain.model.LoginViewModel

interface DataManager {
    fun getLoginData():LoginViewModel
}