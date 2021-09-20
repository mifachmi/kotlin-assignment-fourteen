package com.example.kotlin_assignment_eleven

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.kotlin_assignment_eleven.databinding.RowItemAgentBinding
import java.util.*

class ValorantAgentAdapter(private val listAgent: ArrayList<Agent>) : RecyclerView.Adapter<ValorantAgentAdapter.ListViewHolder>(){

    inner class ListViewHolder(private val binding: RowItemAgentBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(agent: Agent) {
            with(binding){
                Glide.with(itemView.context)
                    .load(agent.photo)
                    .apply(RequestOptions().override(200, 200))
                    .into(civAgent)

                tvNamaAgent.text = agent.name
                tvClassAgent.text = agent.classAgent
                llRowItem.setOnClickListener {
                    Toast.makeText(it.context, agent.name, Toast.LENGTH_SHORT).show()

                    val intent = Intent(itemView.context, DetailAgentActivity::class.java)
                    intent.putExtra("imageAgent", agent.photo)
                    intent.putExtra("nameAgent", tvNamaAgent.text)
                    intent.putExtra("classAgent", tvClassAgent.text)
                    itemView.context.startActivity(intent)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = RowItemAgentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(listAgent[position])
    }

    override fun getItemCount(): Int {
        return listAgent.size
    }
}

data class Agent (
    var name: String,
    var classAgent: String,
    var photo: Int
)
