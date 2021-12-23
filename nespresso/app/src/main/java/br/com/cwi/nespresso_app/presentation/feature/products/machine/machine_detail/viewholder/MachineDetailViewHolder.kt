package br.com.cwi.nespresso_app.presentation.feature.products.machine.machine_detail.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import br.com.cwi.nespresso_app.databinding.ActivityMachineDetailBinding

class MachineDetailViewHolder(item: View) : RecyclerView.ViewHolder(item) {
    val tvName = ActivityMachineDetailBinding.bind(item).tvMachineDetailName
    val tvPrice = ActivityMachineDetailBinding.bind(item).tvMachineDetailPrice
    val ivMachine = ActivityMachineDetailBinding.bind(item).ivMachineDetailPhoto
    val tvDescription = ActivityMachineDetailBinding.bind(item).tvMachineDetailDescription


}