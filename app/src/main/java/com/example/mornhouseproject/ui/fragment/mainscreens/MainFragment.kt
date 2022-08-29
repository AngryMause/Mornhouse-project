package com.example.mornhouseproject.ui.fragment.mainscreens

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.mornhouseproject.MyAdapter
import com.example.mornhouseproject.databinding.FragmentMainBinding
import com.example.mornhouseproject.factory
import com.example.mornhouseproject.model.ResponseModel
import com.example.mornhouseproject.ui.fragment.BaseFragment
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch


class MainFragment : BaseFragment<FragmentMainBinding>(FragmentMainBinding::inflate) {
//    private val myList = mutableListOf<ResponseModel>()

    private lateinit var adapterr: MyAdapter
    private val viewModel: MainViewModel by viewModels { factory() }

    companion object {
        fun newInstance(): MainFragment {
            return MainFragment()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapterr = MyAdapter()
        initRv()
        getRandomNumberFact()

    }


    private fun getRandomNumberFact() {
        binding.myBtn.setOnClickListener {
            lifecycleScope.launch {
                binding.myBtn.isEnabled = false
                viewModel.getResponse().collect { fact ->
                    val lastIndex = fact.lastIndex
                    println(" somne ${it}")
                    binding.tvMy.text = fact[lastIndex].number
                    adapterr.submitList(fact)
                    adapterr.notifyItemInserted(fact.lastIndex+1)
                    binding.myBtn.isEnabled = true
                }
            }
        }
    }


//    private fun getResponse(): Flow<List<ResponseModel>> = flow {
//        val que = Volley.newRequestQueue(requireContext())
//        val url = "http://numbersapi.com/random/math"
//        val stringRequest = StringRequest(Request.Method.GET,
//            url,
//            { response ->
//                myList.add(ResponseModel(response.toString()))
//                Log.d("Repo", myList.size.toString())
//            },
//            null)
//        que.add(stringRequest)
//        binding.myBtn.isEnabled = false
//        delay(1000L)
//        emit(myList)
//        binding.myBtn.isEnabled = true
//    }


    private fun initRv() = binding.myRv.apply {
        adapter = adapterr
        layoutManager = LinearLayoutManager(requireContext())
    }
}



