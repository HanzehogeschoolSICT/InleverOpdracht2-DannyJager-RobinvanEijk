package model;

import java.util.LinkedList;

/**
 * Class which contains information of the character in the boggle field
 * Created by robin on 20-3-17.
 */
public class BoardCharacter {
    private int x;                              // X coordinates
    private int y;                              // Y coordinates
    private boolean used = false;               // Flag containing if the character has already been used
    private LinkedList<Character> neighbours;   // LinkedList containing the neighbours of this character
    private String value;                   // Content of this character

    /**
     * Create a character
     * @param xCor x coordinates
     * @param yCor y coordinates
     * @param character value of this character
     */
    public BoardCharacter(int xCor, int yCor, String character) {
        this.x = xCor;
        this.y = yCor;
        this.value = character;
    }

    /**
     * set X coordinate
     * @param xCor
     */
    public void setX(int xCor) {
        this.x = xCor;

    }

    /**
     * set Y coordinate
     * @param yCor
     */
    public void setY(int yCor) {
        this.y = yCor;

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
    public String getCharacter() {
        return value;
    }

    /**
     * Set the neighbours of this character
     * @param neighbours
     */
    public void setNeighbours(LinkedList<Character> neighbours) {
        this.neighbours = neighbours;
    }

    /**
     * return the list of neighbours of this character
     * @return LinkedList<Character>
     */
    public LinkedList<Character> getNeighbours(){
        return neighbours;
    }

}
