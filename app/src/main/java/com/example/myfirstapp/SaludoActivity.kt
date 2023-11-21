package com.example.myfirstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myfirstapp.databinding.ActivitySaludoBinding

private lateinit var binding: ActivitySaludoBinding
class SaludoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySaludoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getAndShowName()
    }

    private fun getAndShowName() {
        val bundle = intent.extras
        val name =  bundle?.get("name")
        if (name != null){
            binding.tvSaludo.text = "Buenas, $name"
        }else{
            binding.tvSaludo.text = "Buenas, invitado"
        }

    }
}