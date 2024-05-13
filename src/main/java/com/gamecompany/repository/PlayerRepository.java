package com.gamecompany.repository;

import com.gamecompany.models.Player;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class PlayerRepository {

    Map<String,Player> players;

    PlayerRepository(){
        players=new HashMap<>();
    }

    public Player findByName(String playerName) {
        return players.get(playerName);
    }

    public void savePlayer(Player p){
        players.put(p.getName(),p);
    }
}
