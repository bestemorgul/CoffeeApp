package com.bestemorgul.coffeeapp.ui.overview

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bestemorgul.coffeeapp.R
import com.bestemorgul.coffeeapp.databinding.FragmentOverviewBinding

class OverviewFragment : Fragment() {

    private lateinit var binding: FragmentOverviewBinding

    private val viewModel: OverviewViewModel by lazy { OverviewViewModel() }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOverviewBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.lifecycleOwner = this

        binding.viewModel = viewModel

        val adapter = CoffeeAdapter {
        val action = OverviewFragmentDirections.actionOverviewFragmentToDetailFragment(it)
        this.findNavController().navigate(action)
        }

        binding.rvCoffee.adapter = adapter

        viewModel.coffee.observe(this.viewLifecycleOwner) {coffee ->
            coffee.let {
                adapter.submitList(it)
            }
        }
        setHasOptionsMenu(true)


    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.hot_coffee -> viewModel.getHotCoffeeTypes()
            R.id.iced_coffee -> viewModel.getIcedCoffeeTypes()
            else -> viewModel.getIcedCoffeeTypes()
        }
        return true

    }
}


