package com.gamecompany.models;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
public class Board {
    @EmbeddedId
    @Column(name="board_id")
    BoardId boardId;

    @Column(name="mark")
    String mark;

    @ManyToOne
    @JoinColumn(name="game_id")
    Game game;

    @OneToMany
    @JoinColumn(name="player_id")
    Player player;

    public class BoardId{
        @Column(name="board_uuid")
        private UUID boardUuId;

        @Column(name="position")
        Integer position;
    }
}





