package edu.temple.imageactivity

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ImageViewModel : ViewModel() {
    val selected = MutableLiveData<Image>()

    fun select(img: Image) {
        selected.value = img
    }
}