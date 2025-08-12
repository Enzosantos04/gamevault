package com.gamevault.gamevault.mapper;

import com.gamevault.gamevault.dto.GameDTO;
import com.gamevault.gamevault.entity.Game;
import org.springframework.stereotype.Component;

@Component
public class GameMapper {

    public Game map(GameDTO dto) {
        Game game = new Game();
        game.setId(dto.getId());
        game.setTitle(dto.getTitle());
        game.setDescription(dto.getDescription());
        game.setReleaseDate(dto.getReleaseDate());
        return game;
    }


    public GameDTO map(Game game){
        GameDTO dto = new GameDTO();
        dto.setId(game.getId());
        dto.setTitle(game.getTitle());
        dto.setDescription(game.getDescription());
        dto.setReleaseDate(game.getReleaseDate());
        return dto;
    }
}
