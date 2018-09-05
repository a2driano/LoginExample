package com.mind.andrew.login.domain.model

import io.realm.RealmObject

open class UserModel(
        var login: String? = null,
        var password: String? = null) : RealmObject()
