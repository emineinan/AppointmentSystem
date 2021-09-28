package com.example.zonezerocase.view.fragments.list

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.zonezerocase.R
import com.example.zonezerocase.view.fragments.list.adapter.ListAdapter
import com.example.zonezerocase.data.viewmodels.ListViewModel
import com.example.zonezerocase.databinding.FragmentListBinding
import com.example.zonezerocase.setDivider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class ListFragment : Fragment() {
    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!

    private val viewModel: ListViewModel by viewModels<ListViewModel>()
    private val adapter: ListAdapter by lazy { ListAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListBinding.inflate(inflater, container, false)

        setAdapter()
        viewModel.getData()

        viewModel.doctors.observe(viewLifecycleOwner, Observer {
            binding.recyclerView.visibility = View.VISIBLE
            adapter.setData(it.doctors)
        })

        return binding.root
    }

    private fun setAdapter() {
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter
        binding.recyclerView.setDivider(R.drawable.recyclerview_divider)
    }

}