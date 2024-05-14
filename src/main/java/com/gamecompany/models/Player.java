package com.gamecompany.models;

import com.gamecompany.controllers.PlayerRequest;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@NoArgsConstructor
@Data
public class Player {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id")
    UUID playerId;

    @Column(name="player_id")
    private String playerName;

    @ManyToOne
    @JoinColumn(name="game_id")
    private Game game;

    @Column(name="mark")
    private String mark;


    public Player(PlayerRequest playerRequest, Game g) {
        mark=playerRequest.getMark();
        playerName=playerRequest.getName();
        game=g;
    }

}
