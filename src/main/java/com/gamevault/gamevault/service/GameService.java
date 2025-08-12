package com.gamevault.gamevault.service;

import com.gamevault.gamevault.dto.GameDTO;
import com.gamevault.gamevault.entity.Game;
import com.gamevault.gamevault.mapper.GameMapper;
import com.gamevault.gamevault.repository.GameRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GameService {
    private final GameRepository gameRepository;
    private final GameMapper gameMapper;

    public GameService(GameRepository gameRepository, GameMapper gameMapper) {
        this.gameMapper = gameMapper;
        this.gameRepository = gameRepository;
    }

    public List<GameDTO> findAll(){
        List<Game> games = gameRepository.findAll();
        return games.stream()
                .map(gameMapper::map)
                .collect(Collectors.toList());
    }

    public GameDTO saveGame(GameDTO gameDTO){
        Game newGame = gameMapper.map(gameDTO);
        newGame = gameRepository.save(newGame);
        return gameMapper.map(newGame);
    }

    public GameDTO getGameById(Long id){
        return gameRepository.findById(id)
                .map(gameMapper::map)
                .orElse(null);
    }
    public void deleteGameById(Long id){
        gameRepository.deleteById(id);
    }

    public GameDTO updateGameById(Long id, GameDTO gameDTO){
        Optional<Game> existingGame =gameRepository.findById(id);
        if(existingGame.isPresent()){
            Game updatedGame = gameMapper.map(gameDTO);
            updatedGame.setId(id);
            Game gameSaved = gameRepository.save(updatedGame);
            return gameMapper.map(gameSaved);
        }
        return null;

    }




}
