package com.mind.andrew.login.domain.model

import android.databinding.BaseObservable
import android.databinding.Bindable
import com.mind.andrew.login.BR
import com.mind.andrew.login.utils.adapter.StupidErrorListener

data class LoginViewModel(
        val _errorListener: StupidErrorListener?,
        var _login: String,
        var _password: String,
        var _repeatPassword: String?,
        var _validPass: Boolean = true,
        var _validButtonSign: Boolean = false,
        var _validButtonRegister: Boolean = false
) : BaseObservable() {

    var login: String
        @Bindable
        get() = _login
        set(value) {
            _login = value
            notifyPropertyChanged(BR.login)
            validButtonSign = validateButtonSign()
            validButtonRegister = validateButtonRegister()
        }

    var password: String
        @Bindable get() = _password
        set(value) {
            _password = value
            notifyPropertyChanged(BR.password)
            validPass = validatePass()
            validButtonSign = validateButtonSign()
            validButtonRegister = validateButtonRegister()
        }

    var repeatPassword: String?
        @Bindable get() = _repeatPassword
        set(value) {
            _repeatPassword = value
            notifyPropertyChanged(BR.repeatPassword)
            validPass = validatePass()
            validButtonRegister = validateButtonRegister()
        }

    var validPass: Boolean
        @Bindable
        get() = _validPass
        set(value) {
            _validPass = value
            _errorListener?.changeErrorVisibility(_validPass)
            notifyPropertyChanged(BR.validPass)
        }

    var validButtonSign: Boolean
        @Bindable
        get() = _validButtonSign
        set(value) {
            _validButtonSign = validateButtonSign()
            notifyPropertyChanged(BR.validButtonSign)
        }

    var validButtonRegister: Boolean
        @Bindable
        get() = _validButtonRegister
        set(value) {
            _validButtonRegister = validateButtonRegister()
            notifyPropertyChanged(BR.validButtonRegister)
        }

    private fun validatePass(): Boolean {
        return _password == _repeatPassword || _repeatPassword.isNullOrEmpty()
    }

    private fun validateButtonSign(): Boolean {
        return !_password.isEmpty() && !_login.isEmpty()
    }

    private fun validateButtonRegister(): Boolean {
        return _password == _repeatPassword && !_password.isEmpty() && !_login.isEmpty()
    }
}