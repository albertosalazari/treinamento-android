package com.example.nesspresso.presentation.feature.products.accessories.viewHolder

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.nesspresso.R
import com.example.nesspresso.databinding.ItemAccessorieBinding
import com.example.nesspresso.domain.entity.Accessorie
import com.example.nesspresso.presentation.extension.toMoneyFormat

class AccessorieViewHolder(item: View) : RecyclerView.ViewHolder(item) {
    private val tvTitle = ItemAccessorieBinding.bind(item).tvAccessorieTitle
    private val tvPrice = ItemAccessorieBinding.bind(item).tvAccessoriePrice
    private val ivImage = ItemAccessorieBinding.bind(item).ivAccessorieImage
    private val ivBag = ItemAccessorieBinding.bind(item).ivBag
    private val ivFavorite = ItemAccessorieBinding.bind(item).ivFavorite

    fun bind(context: Context, accessorie: Accessorie) {
        tvTitle.text = accessorie.name
        tvPrice.text = accessorie.unitPrice.toMoneyFormat()

        Glide.with(context)
            .load(accessorie.urlImage)
            .placeholder(R.drawable.ic_basket)
            .into(ivImage)
    }
}