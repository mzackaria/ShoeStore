package com.udacity.shoestore.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.LoginLayoutBinding
import com.udacity.shoestore.utils.hideKeyboard

class LoginFragment : Fragment(), View.OnClickListener {

    lateinit var binding: LoginLayoutBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(
            inflater, R.layout.login_layout, container, false
        )

        binding.buttonLogin.setOnClickListener(this)
        binding.buttonRegister.setOnClickListener(this)

        return binding.root
    }

    override fun onClick(v: View?) {
        val email: String = binding.editTextEmail.text.toString()
        val password: String = binding.editTextPassword.text.toString()
        when {
            email.isEmpty() -> Toast.makeText(activity, R.string.error_email_missing, Toast.LENGTH_SHORT).show()
            password.isEmpty() -> Toast.makeText(activity, R.string.error_password_missing, Toast.LENGTH_SHORT).show()
            else -> {
                v?.hideKeyboard()
                findNavController().navigate(LoginFragmentDirections.loginToWelcome())
            }
        }

    }


}