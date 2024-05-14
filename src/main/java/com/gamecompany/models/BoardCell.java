package com.gamecompany.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Entity
public class BoardCell {


    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="cell_id")
    UUID cellId;

    @ManyToOne
    @JoinColumn(name="game_id")
    Game game;

    @Column(name="position")
    Integer position;

    @OneToOne
    Player player;

    @Column(name="mark")
    String mark;

    public BoardCell(Game g, Integer pos) {
        game=g;
        position=pos;
    }

    public BoardCell(){

    }



}





