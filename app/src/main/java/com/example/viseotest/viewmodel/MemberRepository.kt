package com.example.viseotest.viewmodel

import androidx.lifecycle.MutableLiveData
import com.example.viseotest.models.ClubData

import com.example.viseotest.models.Members
import com.example.viseotest.network.DataApi
import kotlinx.coroutines.*
import retrofit2.HttpException

class MemberRepository() {

    private var members = mutableListOf<Members>()
    private var mutableLiveData = MutableLiveData<List<Members>>()
    val completableJob = Job()
    private val coroutineScope = CoroutineScope(Dispatchers.IO + completableJob)

    private val thisApiCorService by lazy {
        DataApi.createCorService()
    }

    fun getMutableLiveData():MutableLiveData<List<Members>> {
        coroutineScope.launch {
            val request = thisApiCorService.getMembersData()
            withContext(Dispatchers.Main) {
                try {

                    val response = request.await()
                    val clubData = response;

                    if (clubData != null && clubData.size>0) {
                        for(memData: ClubData in clubData ){
                            members.addAll(memData.members)
                        }
                        mutableLiveData.value=members;
                    }

                } catch (e: HttpException) {
                    // Log exception //

                } catch (e: Throwable) {
                    // Log error //)
                }
            }
        }
        return mutableLiveData;
    }
}