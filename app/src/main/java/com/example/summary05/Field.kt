package com.example.summary05

data class Field(
    val field_id: Int,
    val hint: String,
    val field_type: String,
    val keyboard: String,
    val required: Boolean,
    val is_active: Boolean,
    val icon: String
)