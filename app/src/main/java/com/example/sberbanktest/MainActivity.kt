package com.example.sberbanktest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.sberbanktest.data.entities.WalkListData
import com.example.sberbanktest.databinding.ActivityMainBinding
import com.example.sberbanktest.presentation.adapter.WalkingAdapter
import com.example.sberbanktest.presentation.viewModel.MainViewModel
import com.example.sberbanktest.utils.Status
import org.koin.android.ext.android.bind
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.example.sberbanktest.utils.MyHandler




class MainActivity : AppCompatActivity() {

    private val mainViewModel by viewModel<MainViewModel>()
    private val binding : ActivityMainBinding by lazy {
        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main).apply {
            lifecycleOwner = this@MainActivity
            //viewModel = mainViewModel
        }
    }
    private lateinit var walkingAdapter: WalkingAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupObservers()
    }

    private fun setupObservers() {
        mainViewModel.walkItem.observe(this, {
            when (it.status) {
                Status.SUCCESS -> {
                    Log.i("Success", it.data.toString())
                    it.data?.let { main ->
                        retrieveList(main)
                    }
                    Toast.makeText(this, "Загрузка завершена", Toast.LENGTH_SHORT).show()
                }
                Status.LOADING -> {
                    Toast.makeText(this, "Загрузка данных", Toast.LENGTH_SHORT).show()
                }
                Status.ERROR -> {
                    Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                }
            }
        })
    }
    private fun retrieveList(walkListData: WalkListData){
        walkingAdapter = WalkingAdapter(walkListData)
        binding.adapter = walkingAdapter
    }
}