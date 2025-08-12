package com.gamevault.gamevault.controller;

import com.gamevault.gamevault.dto.GameDTO;
import com.gamevault.gamevault.service.GameService;
import org.springframework.boot.autoconfigure.graphql.GraphQlProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gamevault/games")
public class GameController {
    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping()
    public ResponseEntity<List<GameDTO>> findAll(){
        List<GameDTO> games = gameService.findAll();
        return ResponseEntity.status(HttpStatus.FOUND).body(games);
    }

    @PostMapping()
    public ResponseEntity<GameDTO> saveGame(@RequestBody GameDTO gameDTO){
        GameDTO savedGame = gameService.saveGame(gameDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedGame);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GameDTO> GetGameById(@PathVariable Long id){
        if(gameService.getGameById(id) != null){
            GameDTO game = gameService.getGameById(id);
            return ResponseEntity.ok(game);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<GameDTO> deleteGameById(@PathVariable Long id){
        if(gameService.getGameById(id) != null){
            gameService.deleteGameById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<GameDTO> updateGameById(@PathVariable Long id, @RequestBody GameDTO gameDTO){
        if(gameService.getGameById(id)!= null){
            GameDTO updatedGame = gameService.updateGameById(id, gameDTO);
            return ResponseEntity.ok(updatedGame);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}
