package com.mind.andrew.login.presentation.list

import android.support.v4.app.ActivityCompat
import com.mind.andrew.login.domain.model.UserModel

interface ListContract {
    interface View {
        fun setData(users: List<UserModel>)
        fun parentActivity(): ActivityCompat
    }

    interface Presenter {
        fun getData()
    }
}