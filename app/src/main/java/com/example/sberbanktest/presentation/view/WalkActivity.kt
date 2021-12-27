package com.example.sberbanktest.presentation.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sberbanktest.R
import android.os.Parcelable
import androidx.databinding.DataBindingUtil
import com.example.sberbanktest.data.entities.Data
import com.example.sberbanktest.data.entities.Route
import com.example.sberbanktest.databinding.ActivityWalkBinding
import com.example.sberbanktest.presentation.adapter.RouteAdapter
import com.example.sberbanktest.presentation.adapter.WalkingAdapter
import com.example.sberbanktest.utils.CharacterItemDecoration
import com.example.sberbanktest.utils.MyHandler


class WalkActivity : AppCompatActivity() {

    private lateinit var routeAdapter: RouteAdapter

    private val binding : ActivityWalkBinding by lazy {
        DataBindingUtil.setContentView<ActivityWalkBinding>(this, R.layout.activity_walk).apply {
            lifecycleOwner = this@WalkActivity
            //viewModel = mainViewModel
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_walk)

        val myData = intent.getParcelableExtra<Parcelable>("data") as Data
        binding.data = myData

        binding.routeRv.addItemDecoration(CharacterItemDecoration(15,true))

        routeAdapter = RouteAdapter(myData.routes)
        binding.adapter = routeAdapter

        val myHandler = MyHandler()
        binding.handler = myHandler
    }
}