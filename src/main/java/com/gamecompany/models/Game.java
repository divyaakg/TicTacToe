package com.gamecompany.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class Game {
    @Id
    @Column(name="game_id")
    private UUID gameid;

    @OneToOne
    @JoinColumn(name="starter_player")
    private Player starter;

    @Column(name = "start_time", columnDefinition = "TIMESTAMP")
    private LocalDateTime startTime;

    public Game(UUID g, Player s, LocalDateTime time){
        gameid=g;
        starter=s;
        startTime= time;
    }

    public Game(){

    }
}
