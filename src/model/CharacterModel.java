package model;

import java.util.Random;

/**
 * Created by Danny on 15-3-2017.
 */
public class CharacterModel {

    // Set of characters of the alphabet
    private char[] setOfCharacters;


    /**
     * Constructor method
     * When this model gets instantiated, it creates a set of characters of the alphabet
     */
    public CharacterModel() {

        setOfCharacters = new char[]{
                'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I',
                'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
                'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'
        };

    }

    /**
     * Generate and return a random character
     *
     * @return char random character
     */
    public char generateRandomCharacter() {
        int randomChar = new Random().nextInt(26);
        return setOfCharacters[randomChar];
    }

}
