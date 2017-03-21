package model;

import text.TextReader;

import java.util.*;

/**
 * Model which contains the Boggle field.
 * Created by robin on 13-3-17.
 */
public class Model {
    private final String filename = "src/text/woordenlijst.txt";        // The path to the Word list.
    private final int fieldSize = 4;                                    // The size of the field
    private BoardCharacter[][] field;                                   // The 2 dimensional array which represents the boggle field.
    private TreeSet<String> wordList;                                   // A TreeSet containing the entire word list
    private ArrayList<String> words = new ArrayList<>();                // Arraylist with words.

    /**
     * Constructs the model with the data structure to save the board
     */
    public Model(){
        TextReader textReader = new TextReader();
        wordList = textReader.textFileToTreeSet(filename);
        createField();
        setNeighBours();
    }

    /**
     * Creates the 2d array field in size fieldSize*fieldsize with the BoardCharacters in it.
     */
    private void createField(){
        field = new BoardCharacter[fieldSize][fieldSize];
        for (int x = 0; x < fieldSize; x++){
            for (int y = 0; y < fieldSize; y++){
                field[x][y] = new BoardCharacter(x,y);
            }
        }
    }

    /**
     * Add neighbours to all BoardCharacters.
     */
    private void setNeighBours(){
        for (int x = 0; x < field.length; x++){
            for (int y = 0; y < field.length; y++){
                //TODO remove prints.
                System.out.println("");
                System.out.println(field[x][y].getCharacter());
                field[x][y].setNeighbours(findNeighBours(x,y));
            }
        }
    }

    /**
     * find all neighbours for an BoardCharacter based on the current location and add them to the BoardCharacter.
     * @param x coordinaten
     * @param y coordinaten
     * @return neighbours
     */
    private LinkedList<BoardCharacter> findNeighBours(int x,int y){
        LinkedList<BoardCharacter> neighbors= new LinkedList<>();
        // Find neighbour on the left top
        if (x-1 >= 0 && y-1 >= 0){
            neighbors.add(field[x-1][y-1]);
        }
        // Find neighbour on the left
        if (x-1 >= 0){
            neighbors.add(field[x-1][y]);
        }
        // Find neighbour on the left bottom
        if (x-1 >= 0 && y+1 < fieldSize){
            neighbors.add(field[x-1][y+1]);
        }
        // Find neighbour on the bottom
        if (y+1 < fieldSize){
            neighbors.add(field[x][y+1]);
        }
        // Find neighbour on the top
        if (y-1 >= 0){
            neighbors.add(field[x][y-1]);
        }
        // Find neighbour on the right top
        if (x+1 < fieldSize && y-1 >= 0){
            neighbors.add(field[x+1][y-1]);
        }
        // Find neighbour on the right
        if (x+1 < fieldSize){
            neighbors.add(field[x+1][y]);
        }
        // Find neighbour on the right bottom
        if (x+1 < fieldSize && y+1 < fieldSize){
            neighbors.add(field[x+1][y+1]);
        }

        for (BoardCharacter bc :neighbors){
            System.out.print(" "+bc.getCharacter());
        }
        return neighbors;
    }



    public ArrayList<String> loopFindWords()
    {
        for (int i = 0; i < fieldSize; i++)
        {
            for (int j = 0; j < fieldSize; j++)
            {
                findWords(field[i][j], field[i][j].getCharacter());
            }
        }
        return words;
    }

    private void findWords(BoardCharacter boardCharacter, String input) {
        String oldInput;
        if(words.contains(input)){
            return;
        }
        // check if input is heel woord of deel van het woord, of beide.
        if (input.length() >=  3){
            if(wordList.contains(input)){
                words.add(input);
            }
        }

        LinkedList<BoardCharacter> neighbours = boardCharacter.getNeighbours();
        for (BoardCharacter neighbour : neighbours) {
            if (!neighbour.isUsed()) {
                oldInput = input + neighbour.getCharacter();
                boardCharacter.setUsed(true);
                findWords(neighbour, oldInput);
            }
            boardCharacter.setUsed(false);
        }
    }




/**
 * returns the 2 dimensional field
 * @return field
 */
    public BoardCharacter[][] getField(){
        return field;
    }
}
