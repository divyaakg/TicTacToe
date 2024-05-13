package com.gamecompany.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
public class Player {
    @Id
    @Column(name="player_id")
    private String playerId;

    @ManyToOne
    @JoinColumn(name="game_id")
    private Game game;

    @Column(name="mark")
    private String mark;

}
