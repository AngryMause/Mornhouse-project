package com.example.mornhouseproject.ui.fragment.mainscreens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mornhouseproject.model.ResponseModel
import com.example.mornhouseproject.network.Repository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class MainViewModel() : ViewModel() {

    val factFlow = flow<Int> {
        val startValue = 10
        var currentVal = startValue
        emit(currentVal)
        while (currentVal > 0) {
            delay(1000L)
            currentVal--
            emit(currentVal)

        }
    }

    init {
        collectFlow()
    }

    private fun collectFlow() {
        viewModelScope.launch {
            factFlow.collect { timer ->
                println("Timer  "+timer.toString())
            }
        }
    }


}


//    private val _stateFlow = MutableStateFlow(ResponseModel(""))
//    val stateFlow: StateFlow<ResponseModel> get() = _stateFlow
//
//    init {
//        viewModelScope.launch {
//            stateFlow.value.number = repo.sendToAPI().toString()
//        }
//    }
//}