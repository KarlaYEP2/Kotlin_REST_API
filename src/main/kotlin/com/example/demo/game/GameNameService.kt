package com.example.demo.game

import com.example.demo.GameNames
import com.example.demo.NotFoundException
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service


@Service
class GameNameService(private val GameNameRepository: GameNameRepository) {

    /** Get a list of all games */
    fun getAllGame(): List<GameNames> = GameNameRepository.findAll()

    /** Get game by id */
    fun getGameById(gameId: Long): GameNames = GameNameRepository.findById(gameId)
        .orElseThrow { NotFoundException(HttpStatus.NOT_FOUND, "No matching games were found") }

    /** Creates game */
    fun createGame(game: GameNames): GameNames = GameNameRepository.save(game)

    /** Updates game */
    fun updateGameById(gameId: Long, game: GameNames): GameNames {
        return if (GameNameRepository.existsById(gameId)) {
            GameNameRepository.save(
                GameNames(
                    id = game.id,
                    gameName = game.gameName
                )
            )
        } else throw NotFoundException(HttpStatus.NOT_FOUND, "No matching games were found")
    }

    /** Deletes game */
    fun deleteGameById(gameId: Long) {
        return if (GameNameRepository.existsById(gameId)) {
            GameNameRepository.deleteById(gameId)
        } else throw NotFoundException(HttpStatus.NOT_FOUND, "No matching games were found")
    }
}