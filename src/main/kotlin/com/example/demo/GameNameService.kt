package com.example.demo

import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service


@Service
class GameNameService(private val GameNameRepository: GameNameRepository) {

    /** Get a list of all games */
    fun getAllGame(): List<GameNames> = GameNameRepository.findAll()

    /** Get game by id */
    fun getGameById(gameId: Long): GameNames = GameNameRepository.findById(gameId)
        .orElseThrow { GameNotFoundException(HttpStatus.NOT_FOUND, "No matching game was found") }

    /** Creates game */
    fun createGame(game: GameNames): GameNames = GameNameRepository.save(game)

    /** Updates game */
    fun updateGameById(employeeId: Long, game: GameNames): GameNames {
        return if (GameNameRepository.existsById(employeeId)) {
            GameNameRepository.save(
                GameNames(
                    id = game.id,
                    gameName = game.gameName
                )
            )
        } else throw GameNotFoundException(HttpStatus.NOT_FOUND, "No matching employee was found")
    }

    /** Deletes game */
    fun deleteGameById(gameId: Long) {
        return if (GameNameRepository.existsById(gameId)) {
            GameNameRepository.deleteById(gameId)
        } else throw GameNotFoundException(HttpStatus.NOT_FOUND, "No matching employee was found")
    }
}