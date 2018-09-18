package com.mind.andrew.login.data

import com.mind.andrew.login.domain.model.UserModel
import io.realm.Realm
import io.realm.kotlin.where

object DataManagerImpl : DataManager {

    private val realm: Realm

    init {
        realm = Realm.getDefaultInstance()
    }

    override fun getLoginData(model: UserModel): Boolean {
        var user: UserModel? = null
        realm.executeTransaction { realm ->
            user = realm.where(UserModel::class.java).contains("login", model.login).contains("password", model.password).findFirst() as UserModel?
        }
        return user != null
    }

    override fun saveData(model: UserModel): Boolean {
        //check if user exist
        if (getLoginData(model)) return false
        realm.executeTransaction { realm ->
            var nextID = (realm.where(UserModel::class.java).max("id")) as Long?
            if (nextID == null) nextID = 1
            else nextID++
            val user = realm.createObject(UserModel::class.java, nextID)
            user.login = model.login
            user.password = model.password
        }
        return true
    }

    override fun getData(): List<UserModel> {
        realm.beginTransaction()
        var list: List<UserModel> = realm.where<UserModel>().findAll()
        realm.commitTransaction()
        return realm.copyFromRealm(list)
    }
}