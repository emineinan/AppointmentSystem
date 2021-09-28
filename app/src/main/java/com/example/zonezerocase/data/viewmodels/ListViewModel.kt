package com.example.zonezerocase.data.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.zonezerocase.data.models.Doctors
import com.example.zonezerocase.data.service.RetrofitInstance
import kotlinx.coroutines.launch


private const val TAG = "List ViewModel"
class ListViewModel : ViewModel() {

    private var _doctors = MutableLiveData<Doctors>()
    val doctors: LiveData<Doctors>
        get() = _doctors

    fun getData() {
        viewModelScope.launch {
            try {
                _doctors.value = RetrofitInstance.RetrofitInstance.retrofitInstance.getDoctors()
            } catch (e: Exception) {
                Log.e(TAG, "${e.message}")
            }
        }
    }
}