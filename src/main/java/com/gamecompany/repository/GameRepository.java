package com.gamecompany.repository;

import com.gamecompany.models.Game;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public interface GameRepository extends JpaRepository<Game,UUID> {
    Game findByGameid(UUID gameid);
}
