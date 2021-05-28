package com.udacity.shoestore.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.WelcomeLayoutBinding

class WelcomeFragment : Fragment(), View.OnClickListener {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: WelcomeLayoutBinding = DataBindingUtil.inflate(
            inflater, R.layout.welcome_layout, container, false
        )
        binding.welcomeNextButton.setOnClickListener(this)
        return binding.root
    }

    override fun onClick(v: View?) {
        findNavController().navigate(WelcomeFragmentDirections.welcomeToInstruction())
    }
}