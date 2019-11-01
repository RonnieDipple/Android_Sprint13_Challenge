package com.example.makeup_best_practices_sprint_challenge.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.makeup_best_practices_sprint_challenge.Model.MakeUpProduct

class ListViewModel: ViewModel(){
    val brands = MutableLiveData<List<MakeUpProduct>>()
    val brandLoadError = MutableLiveData<Boolean>()
    val loading = MutableLiveData<Boolean>()

    fun refresh(){
        fetchBrands()

    }

    //prevents exposure of the function that does the functionality
    private fun fetchBrands(){
        //for mock data testing to be removed
        val mockData = listOf(MakeUpProduct("MakeUpProduct 1"),
            MakeUpProduct("MakeUpProduct 2"),
            MakeUpProduct("MakeUpProduct 3"),
            MakeUpProduct("MakeUpProduct 4"),
            MakeUpProduct("MakeUpProduct 5"),
            MakeUpProduct("MakeUpProduct 6"),
            MakeUpProduct("MakeUpProduct 7"),
            MakeUpProduct("MakeUpProduct 8"),
            MakeUpProduct("MakeUpProduct 9"),
            MakeUpProduct("MakeUpProduct 10")
            )

        brandLoadError.value = false
        loading.value = false
        brands.value = mockData
    }
}