package com.example.khabeertask.data.repository

import com.example.khabeertask.data.entity.ProfileResponse
import com.example.khabeertask.utils.DataState
import kotlinx.coroutines.flow.Flow

interface ProfileRepository {
    suspend fun userLogin(): Flow<DataState<ProfileResponse?>>

}