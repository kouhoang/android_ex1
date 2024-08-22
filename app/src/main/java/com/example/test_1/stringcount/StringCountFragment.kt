package com.example.test_1.stringcount

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ListView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.test_1.R
import com.example.test_1.ui.example1.ExampleViewModel1
import com.google.android.material.floatingactionbutton.FloatingActionButton

class StringCountFragment : Fragment() {

    private lateinit var titleEditText1: EditText
    private lateinit var doneBtn1: FloatingActionButton
    private lateinit var listView: ListView
    private lateinit var viewModel: ExampleViewModel1

    /**
     * Phương thức được gọi khi Fragment tạo ra giao diện người dùng của nó.
     * @param inflater LayoutInflater để nạp giao diện người dùng.
     * @param container ViewGroup chứa Fragment.
     * @param savedInstanceState Bundle lưu trạng thái trước đó của Fragment.
     * @return View đối tượng giao diện người dùng của Fragment.
     */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment1, container, false)

        viewModel = ViewModelProvider(this).get(ExampleViewModel1::class.java)

        titleEditText1 = view.findViewById(R.id.titleEditText1)
        doneBtn1 = view.findViewById(R.id.done_btn1)
        listView = view.findViewById(R.id.listString)

        doneBtn1.setOnClickListener {
            saveNote()
        }

        return view
    }

    // Phương thức xử lý việc lưu chuỗi đầu vào và hiển thị tần suất ký tự.
    private fun saveNote() {
        val inputString = titleEditText1.text.toString()

        // Gọi phương thức của ViewModel để tính toán tần suất ký tự.
        viewModel.calculateCharFrequency(inputString)

        // Quan sát sự thay đổi của dữ liệu tần suất ký tự trong ViewModel.
        viewModel.charFrequencyMap.observe(viewLifecycleOwner, Observer { charFrequencyMap ->
            // Tạo danh sách các chuỗi hiển thị tần suất ký tự.
            val displayList = mutableListOf<String>()
            for ((char, freq) in charFrequencyMap) {
                displayList.add("Ký tự: $char, Tần suất: $freq")
            }

            // / Tạo và thiết lập ArrayAdapter cho ListView để hiển thị danh sách tần suất ký tự.
            val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, displayList)
            listView.adapter = adapter
        })
    }
}
