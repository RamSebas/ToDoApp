package aEnterpise.to_do_list.model


import jakarta.persistence.*

@Entity
@Table(name = "todos")
data class ToDo(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val taskID: Long = 0,

    @Column(nullable = false)
    val title: String,

    @Column(nullable = false)
    val description: String,

    @Column(nullable = false)
    val completed: Boolean = false,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    val user: User
)
