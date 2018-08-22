package com.mind.andrew.login.presentation.login

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.mind.andrew.login.R
import com.mind.andrew.login.utils.fragments.addFragmentToActivity

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        addFragmentToActivity(supportFragmentManager, LoginFragment.newInstance(), R.id.container)
    }
}
