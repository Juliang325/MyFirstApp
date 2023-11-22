package com.example.myfirstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.myfirstapp.Fragments.BlueFragment
import com.example.myfirstapp.Fragments.RedFragment
import com.example.myfirstapp.databinding.ActivitySaludoBinding

private lateinit var binding: ActivitySaludoBinding
class SaludoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySaludoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getAndShowName()
        initListeners()

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

    private fun initListeners(){
        binding.btnAzul.setOnClickListener{ replaceFrament(BlueFragment()) }
        binding.btnRed.setOnClickListener{ replaceFrament(RedFragment()) }
    }

    private fun replaceFrament( fragment: Fragment ) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainer, fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }


}