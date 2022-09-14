package com.example.paginationandroid3.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.paginationandroid3.model.UserModel
import com.example.paginationandroid3.network.ApiInterface

class UserPagingSource(private val apiInterface: ApiInterface): PagingSource<Int, UserModel>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, UserModel> {
        return try{
            val position = params.key ?: 1
            val response = apiInterface.getDataFromApi(position)
            return LoadResult.Page(data = response.body()!!.data,
            prevKey = if(position == 1) null else position-1,
            nextKey = if(position == 100) null else position+1)
        }
        catch (e: Exception){
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, UserModel>): Int? {
        return state.anchorPosition?.let{
            state.closestPageToPosition(it)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(it)?.nextKey?.minus(1)
        }
    }

}