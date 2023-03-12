package com.example.khabeertask.data.repository

import com.example.khabeertask.data.entity.ProfileResponse
import com.example.khabeertask.data.remote.EndPoints
import com.example.khabeertask.utils.DataState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ProfileRepositoryImp @Inject
constructor(private val endPoints: EndPoints):ProfileRepository {

    override suspend fun userLogin(): Flow<DataState<ProfileResponse?>> = flow { emit(DataState.Success(endPoints.callGetProfile())) }
}