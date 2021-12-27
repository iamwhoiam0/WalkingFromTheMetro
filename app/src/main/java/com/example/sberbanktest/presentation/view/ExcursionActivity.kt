package com.example.sberbanktest.presentation.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.sberbanktest.R
import com.example.sberbanktest.data.entities.Route
import com.example.sberbanktest.databinding.ActivityExcursionBinding

class ExcursionActivity : AppCompatActivity() {

    private var counter = 0
    lateinit var myRoutes:ArrayList<*>

    private val binding : ActivityExcursionBinding by lazy {
        DataBindingUtil.setContentView<ActivityExcursionBinding>(this, R.layout.activity_excursion).apply {
            lifecycleOwner = this@ExcursionActivity
            //viewModel = mainViewModel
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_excursion)

        myRoutes = intent.getParcelableArrayListExtra<Parcelable>("routes") as ArrayList<*>

        binding.route = myRoutes[0] as Route?

    }

    fun onClickClose(view: View) {
        this.finish()
    }

    fun onClickNext(view: View) {
        if (counter < myRoutes.size - 1){
            counter++
            binding.route = myRoutes[counter] as Route?
            if (counter == myRoutes.size - 1){
                binding.continueBtn.text = "Завершить"
            }
        }else if (counter == myRoutes.size - 1){
            this.finish()
        }
    }

    fun onClickBack(view: View) {
        if (counter == myRoutes.size - 1){
            binding.continueBtn.text = "Далее"
        }
        if (counter > 0){
            counter--
            binding.route = myRoutes[counter] as Route?
        }
    }

}