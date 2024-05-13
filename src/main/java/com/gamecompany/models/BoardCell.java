package com.gamecompany.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Entity
public class BoardCell {
    @ManyToOne
    @JoinColumn(name="game_id")
    Game game;

    @EmbeddedId
    BoardId boardId;

    @OneToOne
    Player player;

    @Column(name="mark")
    String mark;

    public BoardCell(Game g, UUID bId, Integer i) {
        game=g;
        boardId=new BoardId(bId,i);
    }

    public BoardCell(){

    }


    public static class BoardId{
        @Column(name="board_uuid")
        private UUID boardUuId;

        @Column(name="position")
        Integer position;

        public BoardId(UUID id, Integer pos){
            boardUuId=id;
            position=pos;
        }
        public BoardId(){

        }
    }


}





