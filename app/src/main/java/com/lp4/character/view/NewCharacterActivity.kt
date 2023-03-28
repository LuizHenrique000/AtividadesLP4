package com.lp4.character.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lp4.databinding.ActivityNewCharacterBinding

class NewCharacterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNewCharacterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewCharacterBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

}