package com.example.kotlin_assignment_eleven

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlin_assignment_eleven.databinding.ActivityDetailAgentBinding

class DetailAgentActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailAgentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailAgentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle = intent.extras
        if (bundle != null) {
            binding.civAgent.setImageResource(bundle.getInt("imageAgent"))
            binding.tvNamaAgent.text = bundle.getString("nameAgent")
            binding.tvClassAgent.text = bundle.getString("classAgent")
        }
    }
}