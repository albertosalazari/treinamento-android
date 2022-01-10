package com.example.nesspresso.presentation.feature.products.machine

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.nesspresso.R
import com.example.nesspresso.domain.entity.Machine
import com.example.nesspresso.presentation.feature.products.machine.viewHolder.MachineViewHolder

class MachineAdapter(val context: Context, private val list: List<Machine>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MachineViewHolder(inflateView(R.layout.item_machine, parent))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = list[position]

        return (holder as MachineViewHolder).bind(context,item)
    }

    override fun getItemCount() = list.size

    private fun inflateView(layout: Int, parent: ViewGroup) = LayoutInflater
        .from(parent.context)
        .inflate(layout, parent, false)
}