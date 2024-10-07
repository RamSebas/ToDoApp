package aEnterpise.to_do_list.dto

data class ToDoResponse(
    val taskID: Long,
    val title: String,
    val description: String,
    val completed: Boolean,
    val userID: Long // ID del usuario al que pertenece la tarea
)
