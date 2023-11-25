package br.com.globoplay.core.security

import com.google.gson.annotations.SerializedName

data class GPlayException(
    @SerializedName("status_code") val statusCode: Long?,
    @SerializedName("status_message") val message: String?
)