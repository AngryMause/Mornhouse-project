package com.example.mornhouseproject.network

import android.content.Context
import android.util.Log
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.mornhouseproject.model.ResponseModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext

class Repository(private val context: Context) {
//    private lateinit var responseBody: ResponseModel
//
//    suspend fun sendToAPI(): Flow<ResponseModel> {
//        val que = Volley.newRequestQueue(context)
//        val url = "http://numbersapi.com/10"
//        val stringRequest = StringRequest(Request.Method.GET,
//            url,
//            { respons ->
//                responseBody = ResponseModel(respons.toString())
//                Log.d("Reoi", respons.toString())
//
//            },
//            null)
//        que.add(stringRequest)
//        return withContext(Dispatchers.IO) {
//            flow<ResponseModel> { responseBody }
//        }
//    }


}