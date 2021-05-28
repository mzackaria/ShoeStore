package com.udacity.shoestore.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.udacity.shoestore.R
import com.udacity.shoestore.data.ShoeViewModel
import com.udacity.shoestore.databinding.EditShoeLayoutBinding
import com.udacity.shoestore.models.Shoe

class EditShoeFragment : Fragment(){

    private val viewModel: ShoeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: EditShoeLayoutBinding = DataBindingUtil.inflate(
            inflater, R.layout.edit_shoe_layout, container, false
        )
        binding.shoe = Shoe("","","","")

        binding.addShoeButton.setOnClickListener {
            //get the shoe
            //verify it's not empty (at least the name)
            //toast an error if so
            //otherwise add the shoe to viewmodel and close fragment
            val shoe = binding.shoe
            if (shoe == null || shoe.name.isEmpty()) {
                Toast.makeText(activity, getString(R.string.error_edit_shoe), Toast.LENGTH_SHORT).show()
            } else {
                viewModel.add(shoe)
                backToListOfShoe()
            }
        }
        binding.cancelButton.setOnClickListener {
            backToListOfShoe()
        }
        return binding.root
    }

    private fun backToListOfShoe() {
        activity?.onBackPressed()
    }
}