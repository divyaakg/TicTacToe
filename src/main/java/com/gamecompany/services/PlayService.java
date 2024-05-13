package com.gamecompany.services;

import com.gamecompany.controllers.InitRequest;
import com.gamecompany.models.Game;
import com.gamecompany.models.BoardCell;
import com.gamecompany.models.Player;
import com.gamecompany.repository.BoardRepository;
import com.gamecompany.repository.GameRepository;
import com.gamecompany.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class PlayService {
    @Autowired
    GameRepository gameRepo;

    @Autowired
    BoardRepository boardRepo;

    @Autowired
    PlayerRepository playerRepo;

    public UUID startGame(InitRequest request){

        UUID gameId= UUID.randomUUID();
        UUID boardId=UUID.randomUUID();


        Game g=new Game(gameId,null, null,LocalDateTime.now());
        gameRepo.save(g);

        Player p1=new Player(request.getPlayers().get(0),g);
        Player p2=new Player(request.getPlayers().get(1),g);
        playerRepo.save(p1);
        playerRepo.save(p2);

        g.setPlayer1(p1);
        g.setPlayer2(p2);
        gameRepo.save(g);

        List<BoardCell> positions=new ArrayList<>();
        for(int i=0;i<9;i++){
            BoardCell p=new BoardCell(g, boardId, i);
            positions.add(p);
        } boardRepo.saveAll(positions);


        return gameId;
    }

    public void play(UUID gameid, String player, Integer position, String mark) {
        Optional<BoardCell> opb = boardRepo.findByPositionAndBoardId(gameid,position);
        BoardCell b =opb.get();
        b.setPlayer(playerRepo.findByPlayerAndGame(player,gameid));
        b.setMark(mark);
        boardRepo.save(b);
    }
}
