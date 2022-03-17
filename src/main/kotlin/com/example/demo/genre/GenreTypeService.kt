package com.example.demo.genre

import com.example.demo.GenreTypes
import com.example.demo.NotFoundException
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service

@Service
class GenreTypeService(private val genreTypeRepository: GenreTypeRepository) {

    /** Get a list of all genres */
    fun getAllGenres(): List<GenreTypes> = genreTypeRepository.findAll()

    /** Get genre by id */
    fun getGenreById(genreId: Long): GenreTypes = genreTypeRepository.findById(genreId)
        .orElseThrow { NotFoundException(HttpStatus.NOT_FOUND, "No matching genres were found") }

    /** Creates genre */
    fun createGenre(genre: GenreTypes): GenreTypes = genreTypeRepository.save(genre)

    /** Updates genre */
    fun updateGenreById(genreId: Long, genre: GenreTypes): GenreTypes {
        return if (genreTypeRepository.existsById(genreId)) {
            genreTypeRepository.save(
                GenreTypes(
                    id = genre.id,
                    genreType = genre.genreType
                )
            )
        } else throw NotFoundException(HttpStatus.NOT_FOUND, "No matching genres were found")
    }

    /** Deletes genre */
    fun deleteGenreById(genreId: Long) {
        return if (genreTypeRepository.existsById(genreId)) {
            genreTypeRepository.deleteById(genreId)
        } else throw NotFoundException(HttpStatus.NOT_FOUND, "No matching genres were found")
    }
}