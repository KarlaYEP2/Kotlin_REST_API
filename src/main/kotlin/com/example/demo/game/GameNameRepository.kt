package com.example.demo.game

import com.example.demo.GameNames
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface GameNameRepository : JpaRepository<GameNames, Long>
