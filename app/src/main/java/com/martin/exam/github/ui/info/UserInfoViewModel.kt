package com.martin.exam.github.ui.info

import androidx.lifecycle.ViewModel
import com.martin.exam.github.model.UserInfoRepository
import com.martin.exam.github.model.Users
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class UserInfoViewModel @Inject constructor(private val repository: UserInfoRepository) :
    ViewModel() {

    fun getUserInfo(id: String): Flow<Users?> {
        return repository.getUserInfo(id)
    }

}