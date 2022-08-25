package com.example.mornhouseproject.ui.fragment.secondscreens

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import com.example.mornhouseproject.databinding.FragmentSecondBinding
import com.example.mornhouseproject.ui.fragment.BaseFragment

const val NUMBERS = "numbers"

class SecondFragment : BaseFragment<FragmentSecondBinding>(FragmentSecondBinding::inflate) {

    companion object {
        fun newInstance(arg: String): SecondFragment {
            val secondFragment = SecondFragment()
            secondFragment.arguments = bundleOf(NUMBERS to arg)
            return secondFragment
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.factTv.text = requireArguments().get(NUMBERS).toString()
    }
}