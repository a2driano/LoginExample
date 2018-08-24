package com.mind.andrew.login.presentation.login


import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import com.mind.andrew.login.R
import com.mind.andrew.login.databinding.FragmentSignBinding
import com.mind.andrew.login.domain.model.LoginViewModel
import com.mind.andrew.login.utils.adapter.StupidErrorListener

class FragmentSignUp : Fragment(), LoginContract.LoginView, StupidErrorListener {
    private lateinit var presenter: LoginContract.LoginPresenter
    private lateinit var binding: FragmentSignBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = LoginPresenter(this, context)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_sign, container, false)
        binding.listener = presenter
        binding.model = LoginViewModel(this, "", "", "")
        binding.buttonRegister.visibility = View.VISIBLE
        return binding.root
    }

    override fun successLogin(msg: String) {
        binding.textInputLayout.isErrorEnabled = false
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
    }

    override fun errorLogin(msg: String) {
        binding.textInputLayout.isErrorEnabled = true
        binding.textInputLayout.error = msg
    }

    override fun changeErrorVisibility(visible: Boolean) {
        Log.e("tag", "changeErrorVisibility : $visible")
        binding.passSecondTextLayout.isErrorEnabled = !visible
        binding.passSecondTextLayout.error = getString(R.string.error_wrong_second_pass)
    }

    companion object {
        @JvmStatic
        fun newInstance() = FragmentSignUp()
    }
}
