package aEnterpise.to_do_list.model

import jakarta.persistence.*

@Entity
@Table(name = "users")
data class UserEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val name: String,
    @Column(nullable = false, unique = true)
    val email: String,
    @Column(nullable = false)
    val password: String,
    @OneToMany(mappedBy = "user", cascade = [CascadeType.ALL], orphanRemoval = true)
    val tasks: List<Task> = emptyList()
) {

    fun isAccountNonExpired(): Boolean {
        return true
    }

    fun isAccountNonLocked(): Boolean {
        return true
    }

    fun isCredentialsNonExpired(): Boolean {
        return true
    }

    fun isEnabled(): Boolean {
        return true
    }
}
