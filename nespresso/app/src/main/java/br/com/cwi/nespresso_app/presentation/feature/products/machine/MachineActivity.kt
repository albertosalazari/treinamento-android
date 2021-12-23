package br.com.cwi.nespresso_app.presentation.feature.products.machine

import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import br.com.cwi.nespresso_app.R
import br.com.cwi.nespresso_app.databinding.ActivityMachineBinding
import br.com.cwi.nespresso_app.domain.entity.Machine
import br.com.cwi.nespresso_app.presentation.base.BaseBottomNavigation
import br.com.cwi.nespresso_app.presentation.extension.visibleOrGone
import br.com.cwi.nespresso_app.presentation.feature.products.machine.machine_detail.MachineDetailActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.koin.androidx.viewmodel.ext.android.viewModel

class MachineActivity : BaseBottomNavigation() {

    private lateinit var binding: ActivityMachineBinding
    private lateinit var machineDetail: MachineDetailActivity

    private val viewModel: MachineViewModel by viewModel()

    override val currentTab: Int = R.id.products_menu

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMachineBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        setUpViewModel()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun getBottomNavigation(): BottomNavigationView = binding.contentBottomNavigation.root

    private fun setUpViewModel() {
        viewModel.machines.observe(this@MachineActivity) { list ->
            setUpAdapter(list)
        }

        viewModel.loading.observe(this@MachineActivity) { isLoading ->
            binding.viewLoading.root.visibleOrGone(isLoading)
        }

        viewModel.error.observe(this@MachineActivity) { hasError ->
            binding.viewError.root.visibleOrGone(hasError)
        }

        viewModel.fetchMachines()
    }

    private fun setUpAdapter(machines: List<Machine>) {
        binding.rvMachines.apply {
            adapter = MachineAdapter(context = context, machines) {
                val intent = Intent(context, MachineDetailActivity::class.java)
                intent.putExtra("id", it.id)
                intent.putExtra("name", it.name)
                context.startActivity(intent)
            }
            layoutManager = GridLayoutManager(context, 2)
        }
    }

}