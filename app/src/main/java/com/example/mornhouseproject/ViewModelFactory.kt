package com.example.mornhouseproject

import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.mornhouseproject.ui.fragment.mainscreens.MainViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect

class ViewModelFactory( private val app: App,
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
        return super.create(modelClass, extras)
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val viewModel = when (modelClass) {
            MainViewModel::class.java -> {
                MainViewModel(app.repository)
            }

            else -> {
                throw IllegalStateException("Unknown view model Class")
            }
        }
        return viewModel as T
    }
}


fun Fragment.factory() = ViewModelFactory(requireContext().applicationContext as App)
fun <T> Flow<T>.launchWhenStarted(lifecycleCoroutineScope: LifecycleCoroutineScope) {
    lifecycleCoroutineScope.launchWhenStarted {
        this@launchWhenStarted.collect()
    }
}