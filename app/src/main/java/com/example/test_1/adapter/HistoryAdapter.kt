package com.example.test_1.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.test_1.R
import com.example.test_1.model.HistoryItem

class HistoryAdapter(private val history: List<HistoryItem>) :
    RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder>() {

    /**
     * Phương thức tạo ra ViewHolder mới khi RecyclerView cần một ViewHolder mới.
     * @param parent ViewGroup chứa các ViewHolder.
     * @param viewType Loại của View (không sử dụng trong trường hợp này).
     * @return Một đối tượng HistoryViewHolder mới.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_history, parent, false)
        return HistoryViewHolder(view)
    }

    /**
     * Phương thức liên kết dữ liệu với ViewHolder.
     * @param holder ViewHolder được sử dụng để hiển thị mục dữ liệu.
     * @param position Vị trí của mục dữ liệu trong danh sách.
     */
    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        // Lấy đối tượng HistoryItem tại vị trí hiện tại.
        val item = history[position]

        // Gán tiêu đề của mục lịch sử cho TextView.
        holder.titleTextView.text = item.title

        // Kiểm tra trạng thái của mục lịch sử để gán text phù hợp.
        holder.statusTextView.text = if (item.is_up) "UP!" else "DOWN!"
    }

    // Trả về số lượng history trong danh sách.
    override fun getItemCount(): Int {
        return history.size
    }

    /**
     * Lớp ViewHolder để giữ các View cho mỗi mục lịch sử.
     * @param itemView View đại diện cho một mục lịch sử.
     */
    class HistoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleTextView: TextView = itemView.findViewById(R.id.historyTitle)
        val statusTextView: TextView = itemView.findViewById(R.id.historyStatus)
    }
}
