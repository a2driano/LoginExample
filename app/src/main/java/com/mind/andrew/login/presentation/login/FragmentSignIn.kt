package com.mind.andrew.login.presentation.login


import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import com.mind.andrew.login.R
import com.mind.andrew.login.databinding.FragmentSignBinding
import com.mind.andrew.login.domain.model.LoginViewModel
import kotlinx.android.synthetic.main.fragment_sign.*


class FragmentSignIn : Fragment(), LoginContract.LoginView {


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
        binding.model = LoginViewModel("", "", "")
        binding.buttonSubmit.visibility = View.VISIBLE
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        pass_second_text_layout.visibility = View.INVISIBLE
        pass_second_text.isEnabled = true

    }

    override fun successLogin(msg: String) {
        binding.textInputLayout.isErrorEnabled = false
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
    }

    override fun errorLogin(msg: String) {
        binding.textInputLayout.isErrorEnabled = true
        binding.textInputLayout.error = msg
    }

    companion object {
        @JvmStatic
        fun newInstance() = FragmentSignIn()
    }
}
