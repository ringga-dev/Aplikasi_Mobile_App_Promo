package com.ngga_ring.aplikasimobileapppromo.data.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ngga_ring.aplikasimobileapppromo.data.api.Resource
import com.ngga_ring.aplikasimobileapppromo.data.models.PromoModels
import com.ngga_ring.aplikasimobileapppromo.data.repository.PromoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PromoViewModel @Inject constructor(private val userRepository: PromoRepository) : ViewModel() {

    fun getData(): LiveData<Resource<List<PromoModels>>> {
        val dataResult = MutableLiveData<Resource<List<PromoModels>>>()
        dataResult.value = Resource.loading()

        viewModelScope.launch {
            try {
                val resource = userRepository.getData()
                dataResult.value = resource
            } catch (e: Exception) {
                val errorMessage = e.localizedMessage ?: "Unknown error occurred"
                dataResult.value = Resource.error(errorMessage)
            }
        }
        return dataResult
    }


}