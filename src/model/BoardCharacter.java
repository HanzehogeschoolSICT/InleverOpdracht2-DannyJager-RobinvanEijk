package model;

import java.util.LinkedList;
import java.util.Random;

/**
 * Class which contains information of the character in the boggle field
 * Created by robin on 20-3-17.
 */
public class BoardCharacter {
    private int x;                              // X coordinates
    private int y;                              // Y coordinates
    private boolean used = false;               // Flag containing if the character has already been used
    private LinkedList<BoardCharacter> neighbours;   // LinkedList containing the neighbours of this character
    private char value;                   // Content of this character

    /**
     * Create a character
     * @param xCor x coordinates
     * @param yCor y coordinates
     */
    public BoardCharacter(int xCor, int yCor) {
        this.x = xCor;
        this.y = yCor;
        this.value = createRandomCharacter();
    }

    /**
     * Returns a random character from the alphabet.
     * @return char
     */
    public char createRandomCharacter(){
        Random r = new Random();
        char c = (char) (r.nextInt(26) + 'a');
        return c;
    }

    /**
     * set X coordinate
     * @param xCor
     */
    public void setX(int xCor) {
        this.x = xCor;
    }

    /**
     * return the x coordinate
     * @return
     */
    private int getX(){
        return x;
    }

    /**
     * set Y coordinate
     * @param yCor
     */
    public void setY(int yCor) {
        this.y = yCor;
    }

    /**
     * return the y coordinate
     * @return
     */
    private int getY(){
        return y;
    }

    /**
     * return if the character has been used
     * @return used
     */
    public Boolean isUsed() {
        return used;
    }

    /**
     * set if the character has been used
     * @param used
     */
    public void setUsed(boolean used) {
        this.used = used;
    }

    /**
     * return the content of the character
     * @return character
     */
    public char getCharacter() {
        return value;
    }

    /**
     * Set the neighbours of this character
     * @param neighbours
     */
    public void setNeighbours(LinkedList<BoardCharacter> neighbours) {
        this.neighbours = neighbours;
    }

    /**
     * return the list of neighbours of this character
     * @return LinkedList<Character>
     */
    public LinkedList<BoardCharacter> getNeighbours(){
        return neighbours;
    }

}
