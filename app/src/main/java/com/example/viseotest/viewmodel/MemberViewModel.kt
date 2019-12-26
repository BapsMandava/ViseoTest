package com.example.viseotest.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.viseotest.models.Members

class MemberViewModel : ViewModel() {

    val memberRepository= MemberRepository()
    val allBlog: LiveData<List<Members>> get() = memberRepository.getMutableLiveData()

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text

    override fun onCleared() {
        super.onCleared()
        memberRepository.completableJob.cancel()
    }
}