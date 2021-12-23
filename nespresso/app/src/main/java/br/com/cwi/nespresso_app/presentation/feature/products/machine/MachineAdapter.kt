package br.com.cwi.nespresso_app.presentation.feature.products.machine

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.cwi.nespresso_app.R
import br.com.cwi.nespresso_app.domain.entity.Machine
import br.com.cwi.nespresso_app.presentation.extension.toMoneyFormat
import br.com.cwi.nespresso_app.presentation.feature.products.machine.viewholder.MachineViewHolder
import com.bumptech.glide.Glide

class MachineAdapter(val context: Context,
                     private val list: List<Machine>,
                     private val onClickInfo : (Machine) -> Unit) :
    RecyclerView.Adapter<MachineViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MachineViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_machine, parent, false)
        return MachineViewHolder(view)
    }

    override fun onBindViewHolder(holder: MachineViewHolder, position: Int) {
        with(holder) {
            list[position].let { machine ->
                tvName.text = machine.name
                tvPrice.text = machine.unitPrice.toMoneyFormat(0)

                ivMachine.setOnClickListener {
                    onClickInfo(machine)
                }

                Glide.with(context).load(machine.imageUrl).into(ivMachine)
            }
        }
    }

    override fun getItemCount() = list.size
}