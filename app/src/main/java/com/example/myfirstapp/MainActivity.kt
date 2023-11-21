package com.example.myfirstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import com.example.myfirstapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initListeners()
        initToolbar()

    }

    /***** LISTENERS ******/

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

    /***** TOOLBAR ******/

    private fun initToolbar() {
        var toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        moodToolbar(toolbar)
    }

    private fun moodToolbar(toolbar: Toolbar) {
        toolbar.subtitle = "Es mi primera app"
    }

    /***** MENU ******/

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        return true
    }

    public override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.item_info -> mostrarInfo()
            else -> {
                mostrarError()
            }
        }
        return true
    }



    private fun mostrarInfo() {
        Toast.makeText(this, "Esto es una app para principiantes", Toast.LENGTH_SHORT).show()
    }

    /***** MENSAJE DE ERROR ******/
    private fun mostrarError() {
        Toast.makeText(this, "Ha ocurrido un error", Toast.LENGTH_SHORT).show()
    }
}