package com.udacity.shoestore.fragments

import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.data.ShoeViewModel
import com.udacity.shoestore.databinding.ShoeListLayoutBinding
import com.udacity.shoestore.databinding.ShoeViewBinding
import com.udacity.shoestore.models.Shoe

class ShoeListFragment : Fragment() , View.OnClickListener {

    lateinit var linearLayout: LinearLayoutCompat

    private val viewModel: ShoeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: ShoeListLayoutBinding = DataBindingUtil.inflate(
            inflater, R.layout.shoe_list_layout, container, false
        )

        linearLayout = binding.linearLayout
        binding.shoeViewModel = viewModel

        viewModel.shoeListData.observe(viewLifecycleOwner, { newList ->
            for(shoe in newList) {
                addToLayout(inflater, shoe)
            }
        })

        binding.addShoeButton.setOnClickListener(this)

        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.actionFromListToLogin -> {
                findNavController().navigate(ShoeListFragmentDirections.actionFromListToLogin())
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    //click  to go to detail screen
    override fun onClick(v: View?) {
        findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToEditShoeFragment())
    }

    private fun addToLayout(inflater: LayoutInflater, shoe: Shoe) {
        val binding: ShoeViewBinding = DataBindingUtil.inflate(
            inflater, R.layout.shoe_view, null, false
        )
        binding.shoe = shoe
        linearLayout.addView(binding.root)
    }
}