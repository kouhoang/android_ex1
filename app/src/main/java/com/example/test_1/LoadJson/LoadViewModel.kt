package com.example.test_1.LoadJson

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.Gson

class LoadViewModel : ViewModel() {

    // LiveData saves profile data
    private val _profileData = MutableLiveData<Profile>()
    val profileData: LiveData<Profile> get() = _profileData

    // Convert data in JSON into Profile object and save to LiveData.
    fun loadProfileData(jsonString: String) {
        val profile = Gson().fromJson(jsonString, Profile::class.java)
        _profileData.postValue(profile)
    }
}
