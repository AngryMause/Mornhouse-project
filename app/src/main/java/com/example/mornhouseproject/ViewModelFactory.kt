package com.example.mornhouseproject

//
//class ViewModelFactory(
//    private val app: App,
//) : ViewModelProvider.Factory {
//    override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
//        return super.create(modelClass, extras)
//    }
//
//    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        val viewModel = when (modelClass) {
//            MainViewModel::class.java -> {
////                MainViewModel(app.repository)
//            }
//
//            else -> {
//                throw IllegalStateException("Unknown view model Class")
//            }
//        }
//        return viewModel as T
//    }
//}
//
//
//fun Fragment.factory() = ViewModelFactory(requireContext().applicationContext as App)
//
//fun <T> Flow<T>.launchWhenStarted(lifecycleCoroutineScope: LifecycleCoroutineScope) {
//    lifecycleCoroutineScope.launchWhenStarted {
//        this@launchWhenStarted.collect()
//    }
//}