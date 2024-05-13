package com.gamecompany.services;

import com.gamecompany.models.Mark;
import com.gamecompany.models.Player;
import com.gamecompany.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValidationService {

    @Autowired
    PlayerRepository playerRepo;

    public boolean isPlayersTurn(Player p){
        return true;
    }

    public boolean isPositionEmpty(int position){
        return true;
    }

    public boolean playerOwnsTheMark(Player p, Mark mark){
        //System.out.println(playerRepo.findByName(p.getName()));
        return true;
    }

    public boolean validateAll(String playerName, Mark m, int position){
        Player p=playerRepo.findByName(playerName);
        if(!isPlayersTurn(p))
            return false;
        if (!isPositionEmpty(position))
            return false;
        if (!playerOwnsTheMark(p,m))
            return false;
        return true;
    }
}
