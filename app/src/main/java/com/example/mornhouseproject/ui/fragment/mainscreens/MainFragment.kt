package com.example.mornhouseproject.ui.fragment.mainscreens

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.mornhouseproject.MyAdapter
import com.example.mornhouseproject.ViewModelFactory
import com.example.mornhouseproject.databinding.FragmentMainBinding
import com.example.mornhouseproject.factory
import com.example.mornhouseproject.model.ResponseModel
import com.example.mornhouseproject.network.Repository
import com.example.mornhouseproject.ui.fragment.BaseFragment
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class MainFragment : BaseFragment<FragmentMainBinding>(FragmentMainBinding::inflate) {

    private lateinit var adapterr: MyAdapter
    private val myList = mutableListOf<ResponseModel>()

    private val viewModel = viewModels<MainViewModel>()

    companion object {
        fun newInstance(): MainFragment {
            return MainFragment()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapterr = MyAdapter()
        adapterr.submitList(myList)
        initRv()
        getRandomNumberFact()

        viewModel.value.viewModelScope.launch {
            viewModel.value.factFlow.collect {
                binding.tvMy.text = it.toString()
            }
        }



//        binding.tvMy.text = viewModel.value.factFlow.toString()
    }

    private suspend fun someFun() {

    }

    private fun getRandomNumberFact() {
        binding.myBtn.setOnClickListener {
            getResponse("random/math")
        }
    }


    fun getResponse(sed: String) {
        val que = Volley.newRequestQueue(context)
        val url = "http://numbersapi.com/$sed"
        val stringRequest = StringRequest(Request.Method.GET,
            url,
            { response ->
                myList.add(ResponseModel(response.toString()))
                Log.d("Repo", myList.size.toString())
            },
            null)
        que.add(stringRequest)
    }


    private fun initRv() = binding.myRv.apply {
        adapter = adapterr
        setHasFixedSize(true)
        layoutManager = LinearLayoutManager(requireContext())
    }
//    private fun getNumberFact():Flow<ResponseModel> {
//        binding.randomBtn.setOnClickListener {
//            if (binding.myEdit.text.isEmpty()) {
//                Toast.makeText(requireContext(), "Only Numbers", Toast.LENGTH_SHORT).show()
//            } else {
//                getResponse(binding.myEdit.text.toString())
////                Log.d("Resp", myList.size.toString())
//            }
//        }
//        return flow {
//        }
//    }

}