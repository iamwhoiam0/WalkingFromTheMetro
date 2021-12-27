package com.example.sberbanktest.presentation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sberbanktest.data.entities.WalkListData
import com.example.sberbanktest.data.repository.MainRepository
import com.example.sberbanktest.utils.NetworkHelper
import com.example.sberbanktest.utils.Resource
import kotlinx.coroutines.launch


class MainViewModel (
    private val mainRepository: MainRepository,
    private val networkHelper: NetworkHelper
) : ViewModel() {
    private val _walkItem = MutableLiveData<Resource<WalkListData>>()
    val walkItem: LiveData<Resource<WalkListData>>
        get() = _walkItem

    init {
        getWalkList()
    }
    private fun getWalkList() {
        viewModelScope.launch {
            _walkItem.postValue(Resource.loading(null))
            if (networkHelper.isNetworkConnected()){
                mainRepository.getWalkList().let {
                    if (it.isSuccessful){
                        _walkItem.postValue(Resource.success(it.body()))
                    } else{
                        _walkItem.postValue(Resource.error(it.errorBody().toString(), null))
//                        try {
//                            val jObjError = JSONObject(it.errorBody().toString())
//                            Log.i("errorTag", jObjError.getString("error"))
//                        } catch (e: Exception) {
//                            Log.i("errorTag", e.message.toString())
//                        }
                    }
                }
            }else {
                _walkItem.postValue(Resource.error("No internet connection", null))
            }
        }
    }
}