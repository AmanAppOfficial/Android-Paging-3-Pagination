package com.example.paginationandroid3.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.paginationandroid3.network.ApiInterface
import com.example.paginationandroid3.network.RetrofitHelper
import com.example.paginationandroid3.repository.UserRepo

class MainViewModel: ViewModel() {

    private var apiInterface: ApiInterface = RetrofitHelper.getInstance().create(ApiInterface::class.java)
    var userRepo: UserRepo = UserRepo(apiInterface = apiInterface)

    val list = userRepo.getData().cachedIn(viewModelScope)


}