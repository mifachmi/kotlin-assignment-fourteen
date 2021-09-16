package com.example.kotlin_assignment_eleven

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlin_assignment_eleven.databinding.ActivityDashboardBinding
import java.util.*

class DashboardActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDashboardBinding
    private val list = ArrayList<Agent>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title = "List of Valorant Agent"

        binding.rvAgent.setHasFixedSize(true)
        list.addAll(listAgent)
        showRecyclerList()
    }

    private val listAgent: ArrayList<Agent>
        @SuppressLint("Recycle")
        get() {
            val dataName = resources.getStringArray(R.array.data_agent_name)
            val dataClass = resources.getStringArray(R.array.data_agent_class)
            val dataPhoto = resources.obtainTypedArray(R.array.data_img_agent)
            val listAgentt = ArrayList<Agent>()
            for (i in dataName.indices) {
                val agent = Agent(dataName[i],dataClass[i], dataPhoto.getResourceId(i, -1))
                listAgentt.add(agent)
            }
            return listAgentt
        }

    private fun showRecyclerList() {
        binding.rvAgent.layoutManager = LinearLayoutManager(this)
        val listHeroAdapter = ValorantAgentAdapter(list)
        binding.rvAgent.adapter = listHeroAdapter
    }
}