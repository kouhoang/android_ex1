package com.example.test_1.ui.example1

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
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ExampleFragment1 : Fragment() {

    private lateinit var titleEditText1: EditText
    private lateinit var doneBtn1: FloatingActionButton
    private lateinit var listView: ListView
    private lateinit var viewModel: ExampleViewModel1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.activity_ex_1, container, false)

        viewModel = ViewModelProvider(this).get(ExampleViewModel1::class.java)

        titleEditText1 = view.findViewById(R.id.titleEditText1)
        doneBtn1 = view.findViewById(R.id.done_btn1)
        listView = view.findViewById(R.id.listString)

        doneBtn1.setOnClickListener {
            saveNote()
        }

        return view
    }

    private fun saveNote() {
        val inputString = titleEditText1.text.toString()
        viewModel.calculateCharFrequency(inputString)

        viewModel.charFrequencyMap.observe(viewLifecycleOwner, Observer { charFrequencyMap ->
            val displayList = mutableListOf<String>()
            for ((char, freq) in charFrequencyMap) {
                displayList.add("Ký tự: $char, Tần suất: $freq")
            }

            val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, displayList)
            listView.adapter = adapter
        })
    }
}
