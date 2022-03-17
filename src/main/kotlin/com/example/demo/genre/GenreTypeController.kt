package com.example.demo.genre

import com.example.demo.GenreTypes
import org.springframework.web.bind.annotation.*

@RestController
class GenreTypeController(private val genreTypeService: GenreTypeService) {

    @GetMapping("/genre")
    fun getAllGenres(): List<GenreTypes> = genreTypeService.getAllGenres()

    @GetMapping("/genre/{id}")
    fun getGenreById(@PathVariable("id") genreId: Long): GenreTypes =
        genreTypeService.getGenreById(genreId)

    @PostMapping("/genre")
    fun createGenre(@RequestBody payload: GenreTypes): GenreTypes = genreTypeService.createGenre(payload)

    @PutMapping("/genre/{id}")
    fun updateGenreById(@PathVariable("id") genreId: Long, @RequestBody payload: GenreTypes): GenreTypes =
        genreTypeService.updateGenreById(genreId, payload)

    @DeleteMapping("/genre/{id}")
    fun deleteGenreById(@PathVariable("id") genreId: Long): Unit =
        genreTypeService.deleteGenreById(genreId)
}