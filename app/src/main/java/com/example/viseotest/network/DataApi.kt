package com.example.viseotest.network


import com.example.viseotest.models.Members
import com.example.viseotest.utils.Constants
import io.reactivex.Observable
import retrofit2.http.GET

interface DataApi {
    @GET(value = Constants.ENDPOINT)
    fun getMembersData(): Observable<List<Members>>
}