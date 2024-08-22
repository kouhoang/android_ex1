package com.example.test_1.ui.example1

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ExampleViewModel1 : ViewModel() {

    // LiveData để lưu trữ tần suất xuất hiện của kí tự
    private val _charFrequencyMap = MutableLiveData<Map<Char, Int>>()
    val charFrequencyMap: LiveData<Map<Char, Int>>
        get() = _charFrequencyMap

    // Tính toán tần suất ký tự trong một chuỗi đầu vào.
    fun calculateCharFrequency(inputString: String) {
        val map = mutableMapOf<Char, Int>()

        for (char in inputString.toLowerCase()) { // Chuyển đổi ký tự về chữ thường
            if (char.isLetter()) { // Chỉ xét các ký tự là chữ cái
                if (map.containsKey(char)) {
                    map[char] = map[char]!! + 1
                } else {
                    map[char] = 1
                }
            }
        }

        _charFrequencyMap.value = map
    }
}