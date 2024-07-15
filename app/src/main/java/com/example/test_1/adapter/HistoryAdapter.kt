package com.example.test_1.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.test_1.R
import com.example.test_1.model.HistoryItem

class HistoryAdapter(private val history: List<HistoryItem>) :
    RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_history, parent, false)
        return HistoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        val item = history[position]
        holder.titleTextView.text = item.title
        if (item.is_up) {
            holder.iconImageView.setImageResource(R.drawable.ic_up) // Biểu tượng thăng chức
        } else {
            holder.iconImageView.setImageResource(R.drawable.ic_down) // Biểu tượng giáng chức
        }
    }

    override fun getItemCount(): Int {
        return history.size
    }

    class HistoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleTextView: TextView = itemView.findViewById(R.id.historyTitle)
        val iconImageView: ImageView = itemView.findViewById(R.id.historyIcon)
    }
}
