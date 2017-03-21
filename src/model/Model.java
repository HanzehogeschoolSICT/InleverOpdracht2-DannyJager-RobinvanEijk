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

        return neighbors;
    }


    /**
     * Start of the solving-Algorithm
     * Loop through each character in the field and start the findWords method on it.
     */
    public void startWordFinding()
    {
        for (int i = 0; i < fieldSize; i++)
        {
            for (int j = 0; j < fieldSize; j++)
            {
                findWords(field[i][j], field[i][j].getCharacter());
            }
        }
    }

    /**
     * For a given Boardcharacter find all possible words from this starting point by calling this method recursively.
     * @param boardCharacter
     * @param input
     */
    private void findWords(BoardCharacter boardCharacter, String input) {
        String newInput;
        // Uncomment this if 2 of the same words are not allowed.
        if(words.contains(input)){
            return;
        }

        // If the wordList contains the input we add the input to the words array.
        if(wordList.contains(input)){
            words.add(input);
        }

        // We iterate through the neighbours of the boardCharacter and call findWords() on them recursively.
        LinkedList<BoardCharacter> neighbours = boardCharacter.getNeighbours();
        for (BoardCharacter neighbour : neighbours) {
            //Check if the neighbour isn't used in the input already.
            if (!neighbour.isUsed()) {
                newInput = input + neighbour.getCharacter();
                boardCharacter.setUsed(true);
                findWords(neighbour, newInput);
            }
            boardCharacter.setUsed(false);
        }
    }

    /**
     * Return the arrayList with the found words in it.
     * @return words
     */
    public ArrayList<String> getWords(){
        return words;
    }

    /**
    * returns the 2 dimensional field
    * @return field
    */
    public BoardCharacter[][] getField(){
        return field;
    }
}
