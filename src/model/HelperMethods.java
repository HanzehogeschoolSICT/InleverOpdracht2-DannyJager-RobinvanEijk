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
    public static String[] combinationsPerCharacter(String[][] array, BoardCharacter boardCharacter) {

        String up = null;
        String down = null;
        String left = null;
        String right = null;
        String lowerLeft = null;
        String upperRight = null;
        String lowerRight = null;
        String upperLeft = null;

        String[] result = new String[8];

        // Get character up
        if ((boardCharacter.getY()-1 >= 0) && (boardCharacter.getY()-1 < array.length)) {
             up = array[boardCharacter.getY()-1][boardCharacter.getX()];
        }

        // Get character down
        if ((boardCharacter.getY()+1 >= 0) && (boardCharacter.getY()+1 < array.length)) {
            down = array[boardCharacter.getY()+1][boardCharacter.getX()];
        }

        // Get character left
        if ((boardCharacter.getX()-1 >= 0) && (boardCharacter.getX()-1 < array.length)) {
            left = array[boardCharacter.getY()][boardCharacter.getX()-1];
        }

        // Get character right
        if ((boardCharacter.getX()+1 >= 0) && (boardCharacter.getX()+1 < array.length)) {
            right = array[boardCharacter.getY()][boardCharacter.getX()+1];
        }

        // Get character lower left
        if ((boardCharacter.getY()+1 >= 0) && (boardCharacter.getY()+1 < array.length) && (boardCharacter.getX()-1 >= 0) && (boardCharacter.getX()-1 < array.length) ) {
            lowerLeft = array[boardCharacter.getY()+1][boardCharacter.getX()-1];
        }

        // Get character upper right
        if ((boardCharacter.getY()-1 >= 0) && (boardCharacter.getY()-1 < array.length) && (boardCharacter.getX()+1 >= 0) && (boardCharacter.getX()+1 < array.length) ) {
            upperRight = array[boardCharacter.getY()-1][boardCharacter.getX()+1];
        }

        // Get character upper left
        if ((boardCharacter.getY()-1 >= 0) && (boardCharacter.getY()-1 < array.length)  && (boardCharacter.getX()-1 >= 0) && (boardCharacter.getX()-1 < array.length)) {
            upperLeft = array[boardCharacter.getY()-1][boardCharacter.getX()-1];
        }

        // Get character lower right
        if ((boardCharacter.getY()+1 >= 0) && (boardCharacter.getY()+1 < array.length)  && (boardCharacter.getX()+1 >= 0) && (boardCharacter.getX()+1 < array.length)) {
            lowerRight = array[boardCharacter.getY()+1][boardCharacter.getX()+1];
        }

        return result;
    }

}
