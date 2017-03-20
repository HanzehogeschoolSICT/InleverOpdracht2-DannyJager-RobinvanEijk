package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by danny on 20-3-2017.
 */
public class HelperMethods {

    /**
     * This method checks the combination of neighbours per character on the board
     *
     * @param array
     * @param boardCharacter
     */
    public static BoardCharacter[] combinationsPerCharacter(String[][] array, BoardCharacter boardCharacter) {

        String up = null;
        String down = null;
        String left = null;
        String right = null;
        String lowerLeft = null;
        String upperRight = null;
        String lowerRight = null;
        String upperLeft = null;

        BoardCharacter[] result = new BoardCharacter[8];

        // Get character up
        if ((boardCharacter.getY()-1 >= 0) && (boardCharacter.getY()-1 < array.length)) {
            result[0] = new BoardCharacter(boardCharacter.getY()-1, boardCharacter.getX(), array[boardCharacter.getY()-1][boardCharacter.getX()]);
        }

        // Get character down
        if ((boardCharacter.getY()+1 >= 0) && (boardCharacter.getY()+1 < array.length)) {
            result[1] = new BoardCharacter(boardCharacter.getY()+1, boardCharacter.getX(), array[boardCharacter.getY()+1][boardCharacter.getX()]);
        }

        // Get character left
        if ((boardCharacter.getX()-1 >= 0) && (boardCharacter.getX()-1 < array.length)) {
            result[2] = new BoardCharacter(boardCharacter.getY(), boardCharacter.getX()-1, array[boardCharacter.getY()][boardCharacter.getX()-1]);
        }

        // Get character right
        if ((boardCharacter.getX()+1 >= 0) && (boardCharacter.getX()+1 < array.length)) {
            result[3] = new BoardCharacter(boardCharacter.getY(), boardCharacter.getX()+1, array[boardCharacter.getY()][boardCharacter.getX()+1]);
        }

        // Get character lower left
        if ((boardCharacter.getY()+1 >= 0) && (boardCharacter.getY()+1 < array.length) && (boardCharacter.getX()-1 >= 0) && (boardCharacter.getX()-1 < array.length) ) {
            result[4] = new BoardCharacter(boardCharacter.getY()+1, boardCharacter.getX()-1, array[boardCharacter.getY()+1][boardCharacter.getX()-1]);
        }

        // Get character upper right
        if ((boardCharacter.getY()-1 >= 0) && (boardCharacter.getY()-1 < array.length) && (boardCharacter.getX()+1 >= 0) && (boardCharacter.getX()+1 < array.length) ) {
            result[5] = new BoardCharacter(boardCharacter.getY()-1, boardCharacter.getX()+1, array[boardCharacter.getY()-1][boardCharacter.getX()+1]);
        }

        // Get character upper left
        if ((boardCharacter.getY()-1 >= 0) && (boardCharacter.getY()-1 < array.length)  && (boardCharacter.getX()-1 >= 0) && (boardCharacter.getX()-1 < array.length)) {
            result[6] = new BoardCharacter(boardCharacter.getY()-1, boardCharacter.getX()-1, array[boardCharacter.getY()-1][boardCharacter.getX()-1]);
        }

        // Get character lower right
        if ((boardCharacter.getY()+1 >= 0) && (boardCharacter.getY()+1 < array.length)  && (boardCharacter.getX()+1 >= 0) && (boardCharacter.getX()+1 < array.length)) {
            result[7] = new BoardCharacter(boardCharacter.getY()+1, boardCharacter.getX()+1, array[boardCharacter.getY()+1][boardCharacter.getX()+1]);
        }

        return result;
    }

}
