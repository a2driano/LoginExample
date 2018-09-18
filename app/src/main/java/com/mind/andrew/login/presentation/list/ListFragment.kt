package com.mind.andrew.login.presentation.list


import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.mind.andrew.login.R
import com.mind.andrew.login.domain.model.UserModel
import com.mind.andrew.login.presentation.list.adapter.ListAdapter
import com.mind.andrew.login.presentation.login.LoginPresenter
import kotlinx.android.synthetic.main.fragment_list.*


class ListFragment : Fragment(), ListContract.View {


    private lateinit var recycler: RecyclerView
    private lateinit var presenter: ListPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = ListPresenter(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recycler = recyclerView
        recycler.layoutManager = LinearLayoutManager(activity)

        presenter.getData()
    }

    override fun parentActivity(): ActivityCompat {
        return this.parentActivity()
    }

    override fun setData(users: List<UserModel>) {
        recycler.adapter = ListAdapter(users)
    }

    companion object {
        @JvmStatic
        fun newInstance() = ListFragment()
    }
}
