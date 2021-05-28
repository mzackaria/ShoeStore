package com.udacity.shoestore.models

import android.os.Parcelable
import android.text.Editable
import android.text.TextWatcher
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
class Shoe(var name: String, var size: String, var company: String, var description: String,
                val images: List<String> = mutableListOf()) : Parcelable