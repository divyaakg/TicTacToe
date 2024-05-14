package com.gamecompany.controllers;

import com.gamecompany.models.Mark;
import com.gamecompany.services.PlayService;
import com.gamecompany.services.ShowService;
import com.gamecompany.services.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/tictactoe")
public class TicTacToeController {

    @Autowired
    PlayService playService;
    @Autowired
    ValidationService validationService;
    @Autowired
    ShowService showService;

    @GetMapping("/v1/turn")
    public String whoseTurn(){
        return "Divya";
    }



    @PostMapping("/v1/{gameid}/{player}/{position}/{mark}")
    public ShowResponse playTurn(@PathVariable("gameid") UUID gameid,
                            @PathVariable("player") String player,
                              @PathVariable("position") Integer position,
                              @PathVariable ("mark") String mark){
        playService.play(gameid, player, position, mark);
        return new ShowResponse(showService.getMatrix(gameid),playService.didIWin(gameid,position,mark));
    }



    @PostMapping("/v1/initgame")
    public UUID startGame(@RequestBody InitRequest request){
        return playService.startGame(request);
    }

    @GetMapping("/v1/showMatrix")
    public char[][] getMatrix(@RequestParam("gameId") UUID gameId){
        return showService.getMatrix(gameId);

    }
}
