package com.example.test_1.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.test_1.model.Profile
import com.google.gson.Gson

class ExampleViewModel : ViewModel() {

    // LiveData lưu dữ liệu profile
    private val _profileData = MutableLiveData<Profile>()
    val profileData: LiveData<Profile> get() = _profileData

    // Chuyển đổi dữ liệu trong JSON thành đối tượng Profile và lưu vào LiveData.
    fun loadProfileData(jsonString: String) {
        val profile = Gson().fromJson(jsonString, Profile::class.java)
        _profileData.postValue(profile)
    }
}
