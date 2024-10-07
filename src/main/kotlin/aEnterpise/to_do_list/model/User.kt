package aEnterpise.to_do_list.model

import jakarta.persistence.*

@Entity
@Table(name = "users")
data class User(
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id var userID: Long? = null,
    var username: String,
    var email: String,
    var password: String

)

