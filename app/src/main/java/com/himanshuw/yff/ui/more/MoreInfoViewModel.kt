package com.himanshuw.yff.ui.more

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MoreInfoViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is more info Fragment"
    }
    val text: LiveData<String> = _text
}