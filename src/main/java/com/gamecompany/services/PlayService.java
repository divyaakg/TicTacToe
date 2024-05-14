package com.gamecompany.services;

import com.gamecompany.controllers.InitRequest;
import com.gamecompany.models.Game;
import com.gamecompany.models.BoardCell;
import com.gamecompany.models.Player;
import com.gamecompany.repository.BoardRepository;
import com.gamecompany.repository.GameRepository;
import com.gamecompany.repository.PlayerRepository;
import com.gamecompany.utils.CommonUtil;
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


        Game g=new Game(gameId,LocalDateTime.now());
        gameRepo.save(g);

        Player p1=new Player(request.getPlayers().get(0),g);
        Player p2=new Player(request.getPlayers().get(1),g);
        playerRepo.save(p1);
        playerRepo.save(p2);

        //g.setPlayer1(p1);
        //g.setPlayer2(p2);
        //gameRepo.save(g);

        List<BoardCell> positions=new ArrayList<>();
        for(int i=0;i<9;i++){
            BoardCell p=new BoardCell(g,i);
            positions.add(p);
        } boardRepo.saveAll(positions);


        return gameId;
    }

    public boolean play(UUID gameid, String player, Integer position, String mark) {
        Optional<BoardCell> opb = boardRepo.findByPositionAndBoardId(gameid,position);
        BoardCell b =opb.get();
        Player p=playerRepo.findByPlayerAndGame(player,gameid);
        b.setPlayer(p);
        b.setMark(mark);
        boardRepo.save(b);
        boolean won = didIWin(gameid,position,mark);
        if(won) {
            Game g = gameRepo.findByGameid(gameid);
            g.setWinner(p);
            gameRepo.save(g);
        } return won;
    }

    public boolean didIWin(UUID gameId, Integer position, String mark){
        //00 01 02
        //10 11 12
        //20 21 22
        List<BoardCell> cells=boardRepo.findBoard(gameId);
        char m;
        if (mark.equals("CROSS"))
            m='X';
        else
            m='0';
        char [][]matrix= CommonUtil.getMatrix(cells);
        int x=position/3;
        int y=position%3;
        int j=0;
        for(j=0;j<3;j++){
            if(matrix[x][j]!=m)
                break;
        } if(j==3)
            return true;
        int i=0;
        for(i=0;i<3;i++){
            if(matrix[i][y]==m)
                break;
        } if(i==3)
            return true;
        if (x==y){
            if(matrix[0][0] == m && matrix[1][1] ==m && matrix[2][2]==m)
                return true;
        } if(x+y==2){
            if(matrix[0][2]==m && matrix[1][1]==m && matrix[2][0]==m)
                return true;
        }
        return false;
    }
}
