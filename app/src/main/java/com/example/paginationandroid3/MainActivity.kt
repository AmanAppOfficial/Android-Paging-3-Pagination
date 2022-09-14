package com.example.paginationandroid3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.paginationandroid3.databinding.ActivityMainBinding
import com.example.paginationandroid3.paging.UserPagingAdapter
import com.example.paginationandroid3.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: UserPagingAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = UserPagingAdapter(this)
        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]

        binding.mainRecyclerview.layoutManager = LinearLayoutManager(this)
        binding.mainRecyclerview.setHasFixedSize(true)
        binding.mainRecyclerview.adapter = adapter

        mainViewModel.list.observe(this){
            adapter.submitData(lifecycle , it)
        }

    }

}