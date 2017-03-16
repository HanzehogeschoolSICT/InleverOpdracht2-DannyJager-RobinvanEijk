package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Danny on 15-3-2017.
 */
public class CharacterModel {

    // Set of characters of the alphabet
    private static List<String> setOfCharacters;



    /**
     * Constructor method
     * When this model gets instantiated, it creates a set of characters of the alphabet
     */
    public CharacterModel() {

        String[] tempCharacters = new String[]{
                "A", "B", "C", "D", "E", "F", "G", "H", "I",
                "J", "K", "L", "M", "N", "O", "P", "Q", "R",
                "S", "T", "U", "V", "W", "X", "Y", "Z"
        };

        setOfCharacters = new ArrayList<String>();

        for (String value : tempCharacters) {
            setOfCharacters.add(value);
        }


    }

    /**
     * Generate and return a random character
     *
     * @return String random character
     */
    public static String generateRandomCharacter() {
        int randomNumber = new Random().nextInt(26);
        return setOfCharacters.get(randomNumber);
    }

}
