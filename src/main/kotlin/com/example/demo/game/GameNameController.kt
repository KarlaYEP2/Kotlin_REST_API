package com.example.demo.game

import com.example.demo.GameNames
import org.springframework.web.bind.annotation.*

@RestController
class GameNameController(private val gameNameService: GameNameService) {

    @GetMapping("/game")
    fun getAllGame(): List<GameNames> = gameNameService.getAllGame()

    @GetMapping("/game/{id}")
    fun getGameById(@PathVariable("id") gameId: Long): GameNames =
        gameNameService.getGameById(gameId)

    @PostMapping("/game")
    fun createGame(@RequestBody payload: GameNames): GameNames = gameNameService.createGame(payload)

    @PutMapping("/game/{id}")
    fun updateGameById(@PathVariable("id") gameId: Long, @RequestBody payload: GameNames): GameNames =
        gameNameService.updateGameById(gameId, payload)

    @DeleteMapping("/game/{id}")
    fun deleteGameById(@PathVariable("id") gameId: Long): Unit =
        gameNameService.deleteGameById(gameId)
}