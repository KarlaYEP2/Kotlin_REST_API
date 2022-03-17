package com.example.demo.genre

import com.example.demo.GenreTypes
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface GenreTypeRepository : JpaRepository<GenreTypes, Long>