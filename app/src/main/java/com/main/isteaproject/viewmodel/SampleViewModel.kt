package com.main.isteaproject.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.main.isteaproject.model.Sample
import com.main.isteaproject.repository.SampleRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class SampleViewModel: ViewModel() {
    val sampleDetailFlow = MutableStateFlow<Sample?>(null)

    init {
        viewModelScope.launch {
            kotlin.runCatching {
                SampleRepository.getSampleDetail()
            }.onSuccess {
                sampleDetailFlow.value = it
            }.onFailure {
                sampleDetailFlow.value = null
            }
        }
    }
}