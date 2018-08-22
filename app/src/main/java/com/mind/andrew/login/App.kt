package com.mind.andrew.login

import android.app.Application

class App : Application() {

    companion object {
        //example variable
        var login: String = "foo"
        var password: String = "bar"
    }
}