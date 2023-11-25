package br.com.globoplay.presentation.streams.list.data.model.response

import br.com.globoplay.presentation.streams.list.data.model.dto.GenreDTO
import com.google.gson.annotations.SerializedName

data class GenresResponse(
    @SerializedName("genres") val genres: List<GenreDTO>?
)