package com.example.mornhouseproject.ui.fragment.mainscreens

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mornhouseproject.model.NumberFactModel
import com.example.mornhouseproject.network.MaineRepository
import com.example.mornhouseproject.room.DBRepository
import com.example.mornhouseproject.room.NumbersFactBDEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val dbRepository: DBRepository,
    private val repository: MaineRepository,
) : ViewModel() {
    private val _factList = MutableLiveData<List<NumberFactModel>>()
    val fact: LiveData<List<NumberFactModel>> get() = _factList

    init {
        viewModelScope.launch(Dispatchers.IO) {
            dbRepository.listFact().collect {
                _factList.postValue(it)
            }
        }
    }

    suspend fun getNumberFact(number: Int) {
        val data = repository.getNumberFact(number)
        saveNumberFactToDB(NumbersFactBDEntity.fromApiModel(data))
    }


    suspend fun getRandomFact() {
        val data = repository.getRandomFact()
        saveNumberFactToDB(NumbersFactBDEntity.fromApiModel(data))
    }

    private suspend fun saveNumberFactToDB(numbersFactBDEntity: NumbersFactBDEntity) {
        dbRepository.addFact(numbersFactBDEntity)
    }

}




