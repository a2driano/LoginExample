package com.mind.andrew.login.domain.model

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class UserModel(
        @PrimaryKey
        var id: Long = 0,
        var login: String? = null,
        var password: String? = null) : RealmObject()
