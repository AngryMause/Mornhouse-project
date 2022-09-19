package com.example.mornhouseproject.ui.fragment.mainscreens

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mornhouseproject.databinding.FragmentMainBinding
import com.example.mornhouseproject.ui.fragment.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainScreenFragment : BaseFragment<FragmentMainBinding>(FragmentMainBinding::inflate) {
    private lateinit var adapterr: MainScreenAdapter
    private val viewModel: MainViewModel by viewModels()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapterr = MainScreenAdapter()
        navigateToSecondScreen(view)
        addFactToAdapterList()
        initRv()
        checkInput()
        getRandomFact()
    }

    private fun checkInput() {
        val number = binding.myEdit.text
        binding.factBtn.setOnClickListener {
            if (!number.isNullOrEmpty()) {
                if (number.length > 8) {
                    Toast.makeText(requireContext(), "To long number  ", Toast.LENGTH_SHORT).show()
                } else getNumberFact(Integer.parseInt(number.toString()))
            } else Toast.makeText(requireContext(), "Write number ", Toast.LENGTH_SHORT).show()
        }
    }

    private fun addFactToAdapterList() {
        viewModel.fact.observe(viewLifecycleOwner) {
            adapterr.submitList(it)
        }
    }


    private fun getNumberFact(number: Int) {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.getNumberFact(number)
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

    private fun navigateToSecondScreen(view: View) {
        adapterr.setOnItemClickListener {
            val action = MainScreenFragmentDirections.actionMainFragmentToSecondFragment(it)
            view.findNavController().navigate(action)
        }
    }

}


