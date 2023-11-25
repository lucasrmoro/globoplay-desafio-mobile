package br.com.globoplay.presentation.streams.list.data.model.dto

import com.google.gson.annotations.SerializedName

data class GenreDTO(
    @SerializedName("id") val id: Long?,
    @SerializedName("name") val name: String?
)