package com.example.khabeertask.data.remote

import com.example.khabeertask.data.entity.ProfileResponse
import retrofit2.http.*

interface EndPoints {


    @GET("GetPayroll")
    suspend fun callGetProfile(
    ): ProfileResponse?





}