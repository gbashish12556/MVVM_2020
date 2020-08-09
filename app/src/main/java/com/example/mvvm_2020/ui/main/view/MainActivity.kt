package com.example.mvvm_2020.ui.main.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvm_2020.R
import com.example.mvvm_2020.data.api.ApiHelper
import com.example.mvvm_2020.data.api.ApiServiceFactory
import com.example.mvvm_2020.data.api.ApiServiceImpl
import com.example.mvvm_2020.data.model.User
import com.example.mvvm_2020.ui.main.adapter.MainAdapter
import com.example.mvvm_2020.ui.base.ViewModelFactory
import com.example.mvvm_2020.ui.main.viewmodel.MainViewModel
import com.example.mvvm_2020.ui.main.viewmodel.SharedViewModel
import com.example.mvvm_2020.utils.Status
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private lateinit var model:SharedViewModel
    private lateinit var mainViewModel: MainViewModel
    private var liveData1:MutableLiveData<String> = MutableLiveData()
    private var liveData2:MutableLiveData<String> = MutableLiveData()
    private lateinit var adapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupUI()
        setupViewModel()
        setupObserver()
    }

    private fun setupViewModel() {
        mainViewModel = ViewModelProviders.of(this, ViewModelFactory()).get(MainViewModel::class.java)
    }

    private fun setupUI() {
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = MainAdapter(arrayListOf())
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                recyclerView.context,
                (recyclerView.layoutManager as LinearLayoutManager).orientation
            )
        )
        recyclerView.adapter = adapter
    }
//
    private fun setupObserver() {
        mainViewModel.getUsers().observe(this, Observer {
            when (it.status) {
                Status.SUCCESS -> {
                    progressBar.visibility = View.GONE
                    var message = it.data?.let {
                            renderList(it)
                        "Hi my name is ashish"
                    }
                    Log.d("message",message)
                    recyclerView.visibility = View.VISIBLE
                }
                Status.LOADING -> {
                    progressBar.visibility = View.VISIBLE
                    recyclerView.visibility = View.GONE
                }
                Status.ERROR -> {
                    //Handle Error
                    progressBar.visibility = View.GONE
                    Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                }
            }
        })
    }
//
    private fun renderList(users: List<User>) {
        adapter.addData(users)
        adapter.notifyDataSetChanged()
    }

}