package com.aarafrao.itecksamplekotlin.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aarafrao.itecksamplekotlin.model.CustomerData
import com.aarafrao.itecksamplekotlin.repository.DataRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val repository: DataRepository) : ViewModel() {

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.loadCustomerData("03313344034")
        }
    }

    val data: LiveData<CustomerData>
        get() = repository.data
}
