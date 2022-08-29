package com.example.mornhouseproject.network

import android.util.Log
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.mornhouseproject.App
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class Repository() {

    fun sendToAPI(): Flow<String> = flow {
        val que = Volley.newRequestQueue(App.instance)
        val url = "http://numbersapi.com/27"
        val stringRequest = StringRequest(Request.Method.GET,
            url,
            { respons ->


                Log.d("Reoi", respons.toString())
            },
            null)
        que.add(stringRequest)
    }


}