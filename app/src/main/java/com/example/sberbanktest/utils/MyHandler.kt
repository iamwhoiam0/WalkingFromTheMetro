package com.example.sberbanktest.utils

import android.content.Context
import android.content.Intent
import com.example.sberbanktest.data.entities.Data
import com.example.sberbanktest.data.entities.Route
import com.example.sberbanktest.presentation.view.ExcursionActivity
import com.example.sberbanktest.presentation.view.WalkActivity

class MyHandler {

    fun onClickToWalk(data: Data, context: Context) {  // Обработчик нажатий на элемент списка "Прогулки по Москве"
        val intent = Intent(context, WalkActivity::class.java)
        intent.putExtra("data", data)
        context.startActivity(intent)
    }

    fun onClickToStart(routes: ArrayList<Route>, context: Context){
        val intent = Intent(context, ExcursionActivity::class.java)
        intent.putParcelableArrayListExtra("routes", routes)
        context.startActivity(intent)
    }

}