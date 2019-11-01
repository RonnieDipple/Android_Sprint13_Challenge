package com.example.makeup_best_practices_sprint_challenge.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.makeup_best_practices_sprint_challenge.Model.MakeUpProductData

class ListViewModel: ViewModel(){
    val makeup = MutableLiveData<List<MakeUpProductData>>()
    val makeUpLoadError = MutableLiveData<Boolean>()
    val loading = MutableLiveData<Boolean>()

    fun refresh(){
        fetchBrands()

    }

    //prevents exposure of the function that does the functionality
    private fun fetchBrands(){
        //for mock data testing to be removed
        val mockData = listOf(MakeUpProductData("MakeUpProductData 1", 1,"A", "100",5),
            MakeUpProductData("MakeUpProductData 2", 2,"B", "200",4),
            MakeUpProductData("MakeUpProductData 3", 3,"C", "300",3),
            MakeUpProductData("MakeUpProductData 4", 4,"D", "400",2),
            MakeUpProductData("MakeUpProductData 5", 5,"E", "500",1),
            MakeUpProductData("MakeUpProductData 6", 6,"F", "600",0),
            MakeUpProductData("MakeUpProductData 7", 7,"G", "700",1),
            MakeUpProductData("MakeUpProductData 8", 8,"H", "800",2),
            MakeUpProductData("MakeUpProductData 9", 9,"I", "900",3),
            MakeUpProductData("MakeUpProductData 10", 10,"J", "1000",4)
            )


        makeUpLoadError.value = false
        loading.value = false
        makeup.value = mockData
    }
}