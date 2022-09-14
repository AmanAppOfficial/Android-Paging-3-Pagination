package com.example.paginationandroid3.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.example.paginationandroid3.network.ApiInterface
import com.example.paginationandroid3.paging.UserPagingSource

class UserRepo(private val apiInterface: ApiInterface) {

    fun getData() = Pager(
        config = PagingConfig(pageSize = 10, maxSize = 500, enablePlaceholders = true),
        pagingSourceFactory = {UserPagingSource(apiInterface)}
    ).liveData

}