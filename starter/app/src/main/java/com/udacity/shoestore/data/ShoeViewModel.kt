package com.udacity.shoestore.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeViewModel : ViewModel() {

    private var shoeList: MutableList<Shoe> = mutableListOf()
    private var _shoeListData: MutableLiveData<List<Shoe>> = MutableLiveData(shoeList)
    val shoeListData: LiveData<List<Shoe>>
        get() = _shoeListData

    fun add(shoe: Shoe) {
        shoeList.add(shoe)
        _shoeListData.value = shoeList
    }

}