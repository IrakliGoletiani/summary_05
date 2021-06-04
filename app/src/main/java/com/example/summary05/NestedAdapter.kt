package com.example.summary05

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.summary05.databinding.ItemNestedRvBinding

class NestedAdapter(val fields: Array<Field>) :
    RecyclerView.Adapter<NestedAdapter.FieldsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FieldsViewHolder {
        val binding =
            ItemNestedRvBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FieldsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FieldsViewHolder, position: Int) {
        holder.onBind()
    }

    override fun getItemCount() = fields.size

    inner class FieldsViewHolder(private val binding: ItemNestedRvBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind() {
            val model = fields[adapterPosition]

            binding.editText.id = model.field_id
            binding.editText.hint = model.hint

        }
    }

}