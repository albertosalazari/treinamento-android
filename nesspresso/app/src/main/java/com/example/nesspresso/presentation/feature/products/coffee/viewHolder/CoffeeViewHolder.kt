package com.example.nesspresso.presentation.feature.products.coffee.viewHolder

import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.nesspresso.R
import com.example.nesspresso.databinding.ItemCoffeBinding
import com.example.nesspresso.domain.entity.Coffee
import com.example.nesspresso.presentation.extension.toMoneyFormat

class CoffeeViewHolder(itemView: View, private val onFavoriteClick: (Coffee) -> Unit, private val onCoffeeClick: (Coffee) -> Unit) : RecyclerView.ViewHolder(itemView) {
    private val tvTitle = ItemCoffeBinding.bind(itemView).tvCoffeeTitle
    private val tvSubtitle = ItemCoffeBinding.bind(itemView).tvCoffeeSubtitle
    private val ivImage = ItemCoffeBinding.bind(itemView).ivCoffeeImage
    private val tvIntensity = ItemCoffeBinding.bind(itemView).tvCoffeeIntensity
    private val tvPrice = ItemCoffeBinding.bind(itemView).tvCoffeePrice
    private val ivFavorite = ItemCoffeBinding.bind(itemView).ivFavorite

    fun bind(item: Coffee) {
        tvTitle.text = item.name
        tvSubtitle.text = item.description
        tvIntensity.text = "Intensidade: ${item.intensity.toString()}"
        tvPrice.text = item.unitPrice.toMoneyFormat()

        with(ivFavorite) {
            setImageDrawable(getFavoriteIcon(item))
            setOnClickListener {
                item.isFavorite = !item.isFavorite
                setImageDrawable(getFavoriteIcon(item))
                onFavoriteClick(item)
            }
        }

        Glide.with(itemView.context)
            .load(item.urlImage)
            .placeholder(R.drawable.ic_basket)
            .into(ivImage)

        itemView.setOnClickListener {
            onCoffeeClick(item)
        }
    }

    private fun getFavoriteIcon(coffee: Coffee) =
        ContextCompat.getDrawable(
            itemView.context,
            if (coffee.isFavorite) R.drawable.ic_favorite_filled else R.drawable.ic_favorite_rounded
        )
}