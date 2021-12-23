package br.com.cwi.nespresso_app.presentation.feature.products.machine.machine_detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.cwi.nespresso_app.databinding.ActivityMachineDetailBinding

class MachineDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMachineDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMachineDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val name = intent.extras?.getString("name")
        binding.tvMachineDetailName.text = name

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }



}