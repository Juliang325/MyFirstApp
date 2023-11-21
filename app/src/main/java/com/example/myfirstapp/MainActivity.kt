package com.example.myfirstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.myfirstapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initListeners()
    }

    private fun initListeners() {
        binding.btnSaludar.setOnClickListener { checkValue() }
    }

    private fun checkValue() {
        if (binding.etName.text.toString().isEmpty()){
            Toast.makeText(this, "El nombre no puede estar vacío.", Toast.LENGTH_SHORT).show()
        }else{
            val intent = Intent(this, SaludoActivity::class.java)
            intent.putExtra("name", binding.etName.text.toString())
            startActivity(intent)
        }
    }
}