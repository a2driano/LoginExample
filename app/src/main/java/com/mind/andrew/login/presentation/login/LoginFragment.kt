package com.mind.andrew.login.presentation.login


import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.view.PagerAdapter
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.mind.andrew.login.R
//import com.mind.andrew.loginexample.databinding.FragmentLoginPagerBinding
import com.mind.andrew.login.utils.pager.LoginPagerAdapter
import kotlinx.android.synthetic.main.fragment_login_pager.*
import kotlinx.android.synthetic.main.fragment_login_pager.view.*

/**
 * A simple [Fragment] subclass.
 * Use the [LoginFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class LoginFragment : Fragment() {

    private lateinit var presenter: LoginContract.LoginPresenter
//    private lateinit var binding: FragmentLoginPagerBinding

    companion object {
        @JvmStatic
        fun newInstance() = LoginFragment()
    }

//    override fun successLogin(msg: String) {
//    }
//
//    override fun errorLogin(login: String?, pass: String?) {
//    }
//
//    override fun toggleSignView() {
//
//    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        presenter = LoginPresenter(this)
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
//        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login_pager, container, false)
//        binding.listener = presenter
//
//        return binding.root
        return inflater.inflate(R.layout.fragment_login_pager, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val fragmentAdapter = LoginPagerAdapter(activity?.supportFragmentManager)
        viewpager_main.adapter = fragmentAdapter
        tabs_main.setupWithViewPager(viewpager_main)

        button_sign_in.setOnClickListener { togglePager(0) }
        button_sign_up.setOnClickListener { togglePager(1) }
    }

    private fun togglePager(index: Int) {
        viewpager_main.setCurrentItem(index, true)
        button_sign_in.isEnabled = !button_sign_in.isEnabled
        button_sign_up.isEnabled = !button_sign_up.isEnabled
    }
}
