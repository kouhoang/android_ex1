package com.example.test_1.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.test_1.model.Profile
import com.google.gson.Gson

class ExampleViewModel : ViewModel() {

    private val _profileData = MutableLiveData<Profile>()
    val profileData: LiveData<Profile> get() = _profileData

    fun loadProfileData(jsonString: String) {
        val profile = Gson().fromJson(jsonString, Profile::class.java)
        _profileData.postValue(profile)
    }
}
