package com.example.mornhouseproject.ui.fragment.mainscreens

import android.util.Log
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.ViewModel
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.mornhouseproject.App
import com.example.mornhouseproject.model.ResponseModel
import com.example.mornhouseproject.network.Repository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MainViewModel(private val repository: Repository) : ViewModel() {
    private val myList = mutableListOf<ResponseModel>()


    suspend fun getResponse(): Flow<List<ResponseModel>> = flow {
        val que = Volley.newRequestQueue(App.instance)
        val url = "http://numbersapi.com/random/math"
        val stringRequest = StringRequest(Request.Method.GET,
            url,
            { response ->
                myList.add(ResponseModel(response.toString()))
                Log.d("Repo", myList.size.toString())
            },
            null)
        que.add(stringRequest)
        delay(1000L)
        emit(myList)
    }

    val factFlow = flow<Repository> {
        repository.sendToAPI().collect {

        }
    }

//    init {
//        sendToAPI()
//    }

//    fun sendToAPI(): Flow<String> = flow {
//        val que = Volley.newRequestQueue(App.instance)
//        val url = "http://numbersapi.com/27"
//        val stringRequest = StringRequest(Request.Method.GET,
//            url,
//            { respons ->
//                Log.d("Reoi", respons.toString())
//            },
//            null)
//        que.add(stringRequest)
//
//    }


}

