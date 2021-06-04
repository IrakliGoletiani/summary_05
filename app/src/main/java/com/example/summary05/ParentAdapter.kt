package com.example.summary05

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.summary05.databinding.ItemParentRvBinding

class ParentAdapter : RecyclerView.Adapter<ParentAdapter.FieldsViewHolder>() {

    var fields: List<Array<Field>> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FieldsViewHolder {
        val binding =
            ItemParentRvBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FieldsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FieldsViewHolder, position: Int) {
        holder.onBind()
    }

    override fun getItemCount() = fields.size

    inner class FieldsViewHolder(private val binding: ItemParentRvBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind() {
            val model = fields[adapterPosition]

            binding.rvNested.layoutManager = LinearLayoutManager(binding.root.context)
            val fieldsAdapter = NestedAdapter(model)
            binding.rvNested.adapter = fieldsAdapter
        }
    }

    fun setData(fields: List<Array<Field>>) {
        this.fields = fields
        notifyDataSetChanged()
    }
}