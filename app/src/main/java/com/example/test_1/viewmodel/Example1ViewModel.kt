package com.example.test_1.ui.example1

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ExampleViewModel1 : ViewModel() {

    private val _charFrequencyMap = MutableLiveData<Map<Char, Int>>()
    val charFrequencyMap: LiveData<Map<Char, Int>>
        get() = _charFrequencyMap

    fun calculateCharFrequency(inputString: String) {
        val map = mutableMapOf<Char, Int>()

        for (char in inputString) {
            if (map.containsKey(char)) {
                map[char] = map[char]!! + 1
            } else {
                map[char] = 1
            }
        }

        _charFrequencyMap.value = map
    }
}