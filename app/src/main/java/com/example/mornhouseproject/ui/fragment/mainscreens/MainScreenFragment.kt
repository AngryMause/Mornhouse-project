package com.example.mornhouseproject.ui.fragment.mainscreens

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mornhouseproject.databinding.FragmentMainBinding
import com.example.mornhouseproject.ui.fragment.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainScreenFragment : BaseFragment<FragmentMainBinding>(FragmentMainBinding::inflate),
    View.OnClickListener {
    private lateinit var adapterr: MainScreenAdapter
    private val viewModel: MainViewModel by viewModels()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapterr = MainScreenAdapter()
        initRv()
        viewModel.fact.observe(viewLifecycleOwner) {
            adapterr.submitList(it)
        }
        sendApiRequest(32)
        getRandomFact()
    }

    private fun sendApiRequest(number: Int) {
        binding.factBtn.setOnClickListener {
            viewLifecycleOwner.lifecycleScope.launch {
                viewModel.getNumberFact(number)
            }
        }
    }

    private fun getRandomFact() {
        binding.randomBtn.setOnClickListener {
            viewLifecycleOwner.lifecycleScope.launch {
                viewModel.getRandomFact()
            }
        }
    }


    private fun initRv() = binding.myRv.apply {
        adapter = adapterr
        layoutManager = LinearLayoutManager(requireContext())
    }


    override fun onClick(v: View) {

    }
}


