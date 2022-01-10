package com.example.nesspresso.presentation.feature.products.accessories

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.nesspresso.R
import com.example.nesspresso.domain.entity.Accessorie
import com.example.nesspresso.domain.entity.Category
import com.example.nesspresso.domain.entity.ItemType
import com.example.nesspresso.domain.entity.Type
import com.example.nesspresso.presentation.feature.products.accessories.viewHolder.AccessorieViewHolder
import com.example.nesspresso.presentation.base.BaseCategoryViewHolder

class AccessorieAdapter(val context: Context, private val list: List<Type>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return if (viewType == ItemType.CATEGORY.value) {
            BaseCategoryViewHolder(inflateView(R.layout.item_category, parent))
        } else {
            AccessorieViewHolder(inflateView(R.layout.item_accessorie, parent))
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = list[position]

        if (item.type == ItemType.CATEGORY) {
            (holder as BaseCategoryViewHolder).tvCategory.text = (item as Category).category
        } else {
            (holder as AccessorieViewHolder).bind(context,item as Accessorie)
        }
    }

    override fun getItemCount() = list.size

    override fun getItemViewType(position: Int) = list[position].type.value

    private fun inflateView(layout: Int, parent: ViewGroup) = LayoutInflater
        .from(parent.context)
        .inflate(layout, parent, false)
}

