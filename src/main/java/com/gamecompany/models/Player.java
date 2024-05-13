package com.gamecompany.models;

import com.gamecompany.controllers.PlayerRequest;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Data
public class Player {
    @EmbeddedId
    Identifier id;

    @Column(name="mark")
    private String mark;


    public Player(PlayerRequest playerRequest, Game g) {
        mark=playerRequest.getMark();
        id=new Identifier(playerRequest.getName(), g);
    }

    public static class Identifier{
        @Column(name="player_id")
        private String playerId;

        @ManyToOne
        @JoinColumn(name="game_id")
        private Game game;

        public Identifier(){

        }
        public Identifier(String name, Game g){
            playerId=name;
            game=g;
        }
    }
}
