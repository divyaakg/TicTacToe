package com.gamecompany.repository;

import com.gamecompany.models.BoardCell;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BoardRepository extends JpaRepository<BoardCell, UUID> {
    @Query(nativeQuery=true, value="Select * from BOARD_CELL where game_id=?1 and  position=?2")
    Optional<BoardCell> findByPositionAndBoardId(UUID gameId, Integer pos);

    @Query(nativeQuery=true, value="Select * from BOARD_CELL where game_id=?1 order by position")
    List<BoardCell> findBoard(UUID gameId);

}
