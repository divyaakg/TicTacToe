package com.gamecompany.services;

import com.gamecompany.controllers.InitRequest;
import com.gamecompany.models.Game;
import com.gamecompany.repository.BoardRepository;
import com.gamecompany.repository.GameRepository;
import com.gamecompany.repository.PlayerRepository;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class PlayService {
    @Autowired
    GameRepository gameRepo;

    @Autowired
    BoardRepository boardRepo;

    public void startGame(InitRequest request){
        UUID gameId= UUID.randomUUID();
        UUID boardId=UUID.randomUUID();
        Game g=new Game(gameId,null, LocalDateTime.now());
        gameRepo.save(g);

        //List<Board>
    }
}
