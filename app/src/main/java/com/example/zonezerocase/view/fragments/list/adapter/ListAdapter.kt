package com.example.zonezerocase.view.fragments.list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.zonezerocase.data.models.Doctor
import com.example.zonezerocase.databinding.RowItemBinding
import com.example.zonezerocase.view.fragments.list.ListFragmentDirections

class ListAdapter : RecyclerView.Adapter<ListAdapter.MyViewHolder>() {
    var doctorList = emptyList<Doctor>()

    class MyViewHolder(val binding: RowItemBinding) : RecyclerView.ViewHolder(binding.root) {
        companion object {
            fun from(parent: ViewGroup): MyViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = RowItemBinding.inflate(layoutInflater, parent, false)
                return MyViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder.from(parent)
    }

    override fun getItemCount(): Int {
        return doctorList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = doctorList[position]
        holder.binding.doctor=currentItem

        holder.binding.imageViewNavigateDetail.setOnClickListener {
            val action=ListFragmentDirections.actionListFragmentToUserDetailFragment(currentItem)
            Navigation.findNavController(it).navigate(action)
        }
    }

    fun setData(newDoctorList: List<Doctor>) {
        this.doctorList = newDoctorList
        notifyDataSetChanged()
    }
}