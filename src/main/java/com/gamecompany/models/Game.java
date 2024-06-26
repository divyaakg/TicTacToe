package com.gamecompany.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
public class Game {
    @Id
    @Column(insertable=false, updatable=false, name="game_id")
    private UUID gameid;

    //@OneToOne
    //private Player player1;

    //@OneToOne
    //private Player player2;

    @Column(name = "start_time", columnDefinition = "TIMESTAMP")
    private LocalDateTime startTime;

    @OneToOne
    private Player winner;

    //@OneToOne
    //private Player startedBy;

    public Game(UUID g, LocalDateTime time){
        gameid=g;
        //player1=s1;
        //player2=s2;
        startTime= time;
    }

    public Game(){

    }
}
