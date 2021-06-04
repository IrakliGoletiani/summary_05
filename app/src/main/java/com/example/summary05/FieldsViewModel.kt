package com.example.summary05

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class FieldsViewModel : ViewModel() {

    private val _parsedList = MutableLiveData<List<Array<Field>>>().apply { mutableListOf<Field>() }
    val parsedList: LiveData<List<Array<Field>>> = _parsedList

    fun parseJson() {
        viewModelScope.launch {
            withContext(Dispatchers.Default) {
                val list = Gson().fromJson(json, Array<Array<Field>>::class.java).toList()

                _parsedList.postValue(list)
            }
        }
    }

    val json = "[\n" +
            "   [\n" +
            "      {\n" +
            "         \"field_id\":1,\n" +
            "         \"hint\":\"UserName\",\n" +
            "         \"field_type\":\"input\",\n" +
            "         \"keyboard\":\"text\",\n" +
            "         \"required\":false,\n" +
            "         \"is_active\":true,\n" +
            "         \"icon\":\"https://jemala.png\"\n" +
            "      },\n" +
            "      {\n" +
            "         \"field_id\":2,\n" +
            "         \"hint\":\"Email\",\n" +
            "         \"field_type\":\"input\",\n" +
            "         \"required\":true,\n" +
            "         \"keyboard\":\"text\",\n" +
            "         \"is_active\":true,\n" +
            "         \"icon\":\"https://jemala.png\"\n" +
            "      },\n" +
            "      {\n" +
            "         \"field_id\":3,\n" +
            "         \"hint\":\"phone\",\n" +
            "         \"field_type\":\"input\",\n" +
            "         \"required\":true,\n" +
            "         \"keyboard\":\"number\",\n" +
            "         \"is_active\":true,\n" +
            "         \"icon\":\"https://jemala.png\"\n" +
            "      }\n" +
            "   ],\n" +
            "   [\n" +
            "      {\n" +
            "         \"field_id\":4,\n" +
            "         \"hint\":\"Full Name\",\n" +
            "         \"field_type\":\"input\",\n" +
            "         \"keyboard\":\"text\",\n" +
            "         \"required\":true,\n" +
            "         \"is_active\":true,\n" +
            "         \"icon\":\"https://jemala.png\"\n" +
            "      },\n" +
            "      {\n" +
            "         \"field_id\":14,\n" +
            "         \"hint\":\"Jemali\",\n" +
            "         \"field_type\":\"input\",\n" +
            "         \"keyboard\":\"text\",\n" +
            "         \"required\":false,\n" +
            "         \"is_active\":true,\n" +
            "         \"icon\":\"https://jemala.png\"\n" +
            "      },\n" +
            "      {\n" +
            "         \"field_id\":89,\n" +
            "         \"hint\":\"Birthday\",\n" +
            "         \"field_type\":\"chooser\",\n" +
            "         \"required\":false,\n" +
            "         \"is_active\":true,\n" +
            "         \"icon\":\"https://jemala.png\"\n" +
            "      },\n" +
            "      {\n" +
            "         \"field_id\":898,\n" +
            "         \"hint\":\"Gender\",\n" +
            "         \"field_type\":\"chooser\",\n" +
            "         \"required\":\"false\",\n" +
            "         \"is_active\":true,\n" +
            "         \"icon\":\"https://jemala.png\"\n" +
            "      }\n" +
            "   ]\n" +
            "]\n"
}