package br.com.cwi.nespresso_app.presentation.feature.products.machine.machine_detail

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.cwi.nespresso_app.R
import br.com.cwi.nespresso_app.domain.entity.Machine
import br.com.cwi.nespresso_app.presentation.extension.toMoneyFormat
import br.com.cwi.nespresso_app.presentation.feature.products.machine.machine_detail.viewholder.MachineDetailViewHolder
import com.bumptech.glide.Glide

class MachineDetailAdapter(
    val context: Context,
    private val item: Machine) : RecyclerView.Adapter<MachineDetailViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MachineDetailViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_machine_detail, parent, false)
        return MachineDetailViewHolder(view)
    }

    override fun onBindViewHolder(holder: MachineDetailViewHolder, position: Int) {
        with(holder) {
            tvName.text = item.name
            tvPrice.text = item.unitPrice.toMoneyFormat(0)
            tvDescription.text = item.description

            Glide.with(context).load(item.imageUrl).into(ivMachine)
        }
    }

    override fun getItemCount() = 0

}