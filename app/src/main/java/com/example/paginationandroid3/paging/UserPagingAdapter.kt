package com.example.paginationandroid3.paging

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.paginationandroid3.databinding.ItemLayoutBinding
import com.example.paginationandroid3.model.UserModel

class UserPagingAdapter(private val ctx: Context): PagingDataAdapter<UserModel ,UserPagingAdapter.MyViewHolder >(COMPARATOR) {


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = getItem(position)
        Glide.with(ctx).load(item?.picture).into(holder.txtView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context) , parent , false)
        return MyViewHolder(view)
    }


    class MyViewHolder(itemView: ItemLayoutBinding): RecyclerView.ViewHolder(itemView.root){
        val txtView = itemView.textViewName
    }

    companion object{
        private val COMPARATOR = object : DiffUtil.ItemCallback<UserModel>(){
            override fun areItemsTheSame(oldItem: UserModel, newItem: UserModel): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: UserModel, newItem: UserModel): Boolean {
                return oldItem == newItem
            }

        }
    }


}