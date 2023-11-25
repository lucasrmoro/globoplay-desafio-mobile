package br.com.globoplay.presentation.streams.list.data.model.response

import br.com.globoplay.presentation.streams.list.data.model.dto.StreamDTO
import com.google.gson.annotations.SerializedName

data class StreamsResponse(
    @SerializedName("page") val page: Int?,
    @SerializedName("results") val streams: List<StreamDTO>?,
    @SerializedName("total_pages") val totalPages: Int?,
    @SerializedName("total_results") val totalResults: Int?
)