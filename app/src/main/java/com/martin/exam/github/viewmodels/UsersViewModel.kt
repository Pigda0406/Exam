package com.martin.exam.github.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.martin.exam.github.data.Users
import com.martin.exam.github.data.UsersRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class UsersViewModel @Inject constructor(private val repository: UsersRepository) : ViewModel() {

    private var currentUsersResult: Flow<PagingData<Users>>? = null

    fun gerUsers(): Flow<PagingData<Users>> {
        val result: Flow<PagingData<Users>> = repository.getUser().cachedIn(viewModelScope)
        currentUsersResult = result
        return result
    }
}