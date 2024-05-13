package com.gamecompany.repository;

import com.gamecompany.models.Game;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class GameRepository {
    Map<UUID, Game> games;
    public GameRepository(){
        games=new HashMap<>();
    }

    public void saveGame(Game g){
        games.put(g.getId(),g);
    }

    public Game findGame(UUID g){
        return games.get(g);
    }
}
