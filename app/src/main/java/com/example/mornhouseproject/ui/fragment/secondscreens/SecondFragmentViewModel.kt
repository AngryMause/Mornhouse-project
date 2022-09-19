package com.example.mornhouseproject.ui.fragment.secondscreens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mornhouseproject.room.DBRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SecondFragmentViewModel @Inject constructor(private val dbRepository: DBRepository) :
    ViewModel() {

    fun showDescription(id: Long) {
        viewModelScope.launch(Dispatchers.IO) {
            dbRepository.deleteFromDao(id)
        }
    }
}