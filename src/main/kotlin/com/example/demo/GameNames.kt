package com.example.demo

import javax.persistence.*

@Entity
@Table(name = "game")
data class GameNames(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,
    @Column(name = "game_name", unique = true, nullable = false)
    val gameName: String

)