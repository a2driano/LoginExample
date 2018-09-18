package com.mind.andrew.login.presentation.list

import com.mind.andrew.login.domain.interactor.login.DataInteractorImpl

class ListPresenter(val view: ListContract.View) : ListContract.Presenter {

    private val dataInteractor = DataInteractorImpl

    override fun getData() {
        view.setData(dataInteractor.getData())
    }
}