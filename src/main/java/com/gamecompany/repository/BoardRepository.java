package com.gamecompany.repository;

import com.gamecompany.models.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface BoardRepository extends JpaRepository<Board, Board.BoardId> {

}
