package com.gamecompany.services;

import com.gamecompany.controllers.ShowResponse;
import com.gamecompany.models.BoardCell;
import com.gamecompany.repository.BoardRepository;
import com.gamecompany.utils.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ShowService {

    @Autowired
    BoardRepository boardRepo;

    public char[][] getMatrix(UUID gameId) {
        //ShowResponse resp=new ShowResponse();
        List<BoardCell> cells=boardRepo.findBoard(gameId);
        return CommonUtil.getMatrix(cells);
    }


}
