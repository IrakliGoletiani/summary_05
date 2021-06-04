package com.example.summary05

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.summary05.databinding.FragmentJsonBinding


class JsonFragment : Fragment() {

    val viewModel: FieldsViewModel by viewModels()

    lateinit var binding: FragmentJsonBinding

    private lateinit var adapter: ParentAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentJsonBinding.inflate(layoutInflater)


        adapter = ParentAdapter()

        binding.rvParent.layoutManager = LinearLayoutManager(requireContext())
        binding.rvParent.adapter = adapter

        viewModel.parseJson()

        viewModel.parsedList.observe(viewLifecycleOwner, {
            adapter.setData(it)
        })



        return binding.root
    }
}