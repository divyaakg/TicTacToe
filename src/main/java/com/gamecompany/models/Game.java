package com.gamecompany.models;

import lombok.Data;

import java.util.UUID;

@Data
public class Game {
    private UUID id;
    private Player p1;
    private Player p2;
    private Board board;

    public Game(Player pl1, Player pl2){
        p1=pl1;
        p2=pl2;
        id=UUID.randomUUID();
        board=new Board();
    }

}
