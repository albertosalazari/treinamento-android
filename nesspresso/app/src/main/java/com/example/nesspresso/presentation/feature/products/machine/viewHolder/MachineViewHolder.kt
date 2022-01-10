package com.example.nesspresso.presentation.feature.products.machine.viewHolder

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.nesspresso.R
import com.example.nesspresso.databinding.ItemMachineBinding
import com.example.nesspresso.domain.entity.Machine
import com.example.nesspresso.presentation.extension.toMoneyFormat

class MachineViewHolder(item: View) : RecyclerView.ViewHolder(item) {
    private val tvName = ItemMachineBinding.bind(item).tvMachineName
    private val tvPrice = ItemMachineBinding.bind(item).tvMachinePrice
    private val ivPhoto = ItemMachineBinding.bind(item).ivMachinePhoto
    private val ivFavorite = ItemMachineBinding.bind(item).ivFavorite

    fun bind(context: Context, item: Machine) {
        tvName.text = item.name
        tvPrice.text = item.unitPrice.toMoneyFormat()
        //ivFavorite

        Glide.with(context)
            .load(item.urlImage)
            .placeholder(R.drawable.ic_basket)
            .into(ivPhoto)
    }
}