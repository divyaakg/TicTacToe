package com.gamecompany.controllers;

import com.gamecompany.models.Mark;
import com.gamecompany.services.PlayService;
import com.gamecompany.services.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tictactoe")
public class TicTacToeController {

    @Autowired
    PlayService playService;
    @Autowired
    ValidationService validationService;

    @GetMapping("/v1/turn")
    public String whoseTurn(){
        return "Divya";
    }



    @PostMapping("/v1/{gameid}/{player}/{position}/{mark}")
    public String playTurn(@PathVariable("player") String player,
                              @PathVariable("position") Integer position,
                              @PathVariable ("mark") String mark){
        Mark m=Mark.valueOf(mark);
        validationService.validateAll(player, m, position);
        return "setting for "+player+" and "+position+" with mark "+m;
    }



    @PostMapping("/v1/initgame")
    public String startGame(@RequestBody InitRequest request){
        playService.startGame(request);
        return "1";
    }
}
