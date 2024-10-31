package aEnterpise.to_do_list.dto

import aEnterpise.to_do_list.model.Status

data class ToDoRequest(
    val taskID: Long,
    val title: String,
    val description: String,
    val userID: Long, // Asegúrate de que el ID del usuario esté incluido
    val status: Status
)
