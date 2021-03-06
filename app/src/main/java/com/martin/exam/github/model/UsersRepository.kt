package com.martin.exam.github.model

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.martin.exam.github.network.GithubService
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UsersRepository @Inject constructor(private val service: GithubService) {

    fun getUser(): Flow<PagingData<Users>> {
        return Pager(
            config = PagingConfig(
                enablePlaceholders = false,
                pageSize = NETWORK_PAGE_SIZE
            ), pagingSourceFactory = { UsersPagingSource(service) }

        ).flow
    }

    companion object {
        const val NETWORK_PAGE_SIZE = 30
    }
}