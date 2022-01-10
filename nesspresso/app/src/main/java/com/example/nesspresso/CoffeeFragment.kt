package com.example.nesspresso

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.nesspresso.databinding.FragmentCoffeeBinding
import com.example.nesspresso.domain.entity.Type
import com.example.nesspresso.presentation.feature.products.coffee.CoffeeAdapter
import com.example.nesspresso.presentation.feature.products.coffee.CoffeeViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class CoffeeFragment : Fragment() {

    private lateinit var binding: FragmentCoffeeBinding

    private val viewModel: CoffeeViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCoffeeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpViewModel()
    }

    private fun setUpViewModel() {
        viewModel.coffees.observe(viewLifecycleOwner) { list ->
            setUpCoffeeRecyclerView(list)
        }
        viewModel.fetchCoffees()
    }

    private fun setUpCoffeeRecyclerView(list: List<Type>) {
        binding.rvCapsules.apply {
            addItemDecoration(
                DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
            )
            adapter = CoffeeAdapter(list, onFavoriteClick = {
                viewModel.setFavorite(it)
            }, onCoffeeClick = {
                navigateToCoffeeDetail(it.id)
            })
        }
    }

    private fun navigateToCoffeeDetail(id: Int) {
        findNavController().navigate(
            R.id.coffeeDetailFragment,
            bundleOf(
                Pair(EXTRA_COFFEE_ID, id)
            )
        )
    }
}