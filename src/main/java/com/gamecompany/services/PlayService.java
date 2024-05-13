package com.gamecompany.services;

import com.gamecompany.controllers.InitRequest;
import com.gamecompany.models.Game;
import com.gamecompany.repository.GameRepository;
import com.gamecompany.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayService {
    @Autowired
    PlayerRepository playerRepo;
    @Autowired
    GameRepository gameRepo;
    public void startGame(InitRequest request){
        Game game1=new Game(request.getPlayers().get(0), request.getPlayers().get(1));
        gameRepo.saveGame(game1);
        playerRepo.savePlayer(request.getPlayers().get(0));
        playerRepo.savePlayer(request.getPlayers().get(1));
    }
}
