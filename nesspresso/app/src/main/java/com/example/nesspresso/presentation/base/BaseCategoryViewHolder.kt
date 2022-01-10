package com.example.nesspresso.presentation.base

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.nesspresso.databinding.ItemCategoryBinding

class BaseCategoryViewHolder(item: View) : RecyclerView.ViewHolder(item) {
    val tvCategory = ItemCategoryBinding.bind(item).tvCategory
}
