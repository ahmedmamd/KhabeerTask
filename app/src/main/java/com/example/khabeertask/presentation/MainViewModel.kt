package com.example.khabeertask.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.khabeertask.data.entity.ProfileResponse
import com.example.khabeertask.data.repository.ProfileRepository
import com.example.khabeertask.utils.DataState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel
    @Inject
    constructor(private val profileRepository: ProfileRepository) : ViewModel() {

    private val _addPropertyState: MutableLiveData<DataState<ProfileResponse?>> = MutableLiveData()
    val addPropertyState: LiveData<DataState<ProfileResponse?>>
        get() = _addPropertyState



    fun getProfile(){
        viewModelScope.launch(Dispatchers.IO) {
            profileRepository.userLogin()
                .catch { exception ->
                    _addPropertyState.postValue(DataState.Error(exception.message))
                }.collect {
                    _addPropertyState.postValue(it)
                }
        }
    }
}