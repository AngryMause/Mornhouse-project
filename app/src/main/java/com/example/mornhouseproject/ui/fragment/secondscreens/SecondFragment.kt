package com.example.mornhouseproject.ui.fragment.secondscreens

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.viewModelScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.mornhouseproject.R
import com.example.mornhouseproject.databinding.FragmentSecondBinding
import com.example.mornhouseproject.ui.fragment.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SecondFragment : BaseFragment<FragmentSecondBinding>(FragmentSecondBinding::inflate) {

    private val args by navArgs<SecondFragmentArgs>()
    private val viewModel: SecondFragmentViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.factTv.text = args.factDescription.fact
        binding.number.text = args.factDescription.number.toString()
        binding.deleteBtn.setOnClickListener {
            Toast.makeText(requireContext(),
                "Fact about number: ${args.factDescription.number} was delete", Toast.LENGTH_SHORT)
                .show()
            viewModel.viewModelScope.launch {
                viewModel.showDescription(args.factDescription.id)
            }
            findNavController().navigate(R.id.action_secondFragment_to_mainFragment)
        }

    }
}