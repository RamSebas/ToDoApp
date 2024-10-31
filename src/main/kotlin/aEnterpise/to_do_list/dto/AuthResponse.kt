package aEnterpise.to_do_list.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class AuthResponse(
    @JsonProperty
    val token: String,
)