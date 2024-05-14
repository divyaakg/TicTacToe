package com.gamecompany.utils;

import com.gamecompany.models.BoardCell;

import java.util.List;
import java.util.UUID;

public class CommonUtil {
    public static char[][] getMatrix(List<BoardCell> cells) {
        //ShowResponse resp=new ShowResponse();
        char [][]matrix=new char[3][3];
        for(BoardCell c: cells){
            set(c,matrix);
        } return matrix;
    }

    private static void set(BoardCell cell, char[][]matrix){
        int pos=cell.getPosition();
        //0 1 2
        //3 4 5
        //6 7 8
        int x=pos/3;
        int y=pos%3;
        if(cell.getMark() == null)
            matrix[x][y]='.';
        else
            matrix[x][y]=cell.getMark().equals("ZERO")?'0':'X';
    }
}
