package aEnterpise.to_do_list.dto

data class ToDoRequest(
    val title: String,
    val description: String,
    val userID: Long, // Asegúrate de que el ID del usuario esté incluido
    val completed: Boolean
)
