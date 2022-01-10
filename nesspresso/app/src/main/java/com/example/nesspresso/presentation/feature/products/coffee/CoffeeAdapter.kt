package com.example.nesspresso.presentation.feature.products.coffee

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.nesspresso.R
import com.example.nesspresso.domain.entity.Category
import com.example.nesspresso.domain.entity.Coffee
import com.example.nesspresso.domain.entity.ItemType
import com.example.nesspresso.domain.entity.Type
import com.example.nesspresso.presentation.feature.products.coffee.viewHolder.CoffeeViewHolder
import com.example.nesspresso.presentation.base.BaseCategoryViewHolder


class CoffeeAdapter(private val list: List<Type>, private val onFavoriteClick: (Coffee) -> Unit,
                    private val onCoffeeClick: (Coffee) -> Unit) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return if (viewType == ItemType.CATEGORY.value) {
            val view = inflateView(R.layout.item_category, parent)
            BaseCategoryViewHolder(view)
        } else {
            val view = inflateView(R.layout.item_coffe, parent)
            CoffeeViewHolder(view,onFavoriteClick,onCoffeeClick)
        }
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {
        val item = list[position]

        if (item.type == ItemType.CATEGORY) {
            (viewHolder as BaseCategoryViewHolder).tvCategory.text = (item as Category).category
        } else {
            item as Coffee
            (viewHolder as CoffeeViewHolder).bind(item)
        }
    }

    override fun getItemCount() = list.size

    override fun getItemViewType(position: Int) = list[position].type.value

    private fun inflateView(layout: Int, parent: ViewGroup) = LayoutInflater
        .from(parent.context)
        .inflate(layout, parent, false)
}




