package com.gamecompany.repository;

import com.gamecompany.models.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Repository
public interface PlayerRepository extends JpaRepository<Player,String> {
    @Query(nativeQuery=true, value="select * from PLAYER where player_id=?1 and game_id=?2")
    Player findByPlayerAndGame(String player, UUID gameid);//TODO check optional

}
