package text;

import java.io.*;
import java.util.*;

/**
 * Class which can read in TextFiles.
 * Created by robin on 20-3-17.
 */
public class TextReader {

    /**
     * Constructs a TextReader
     */
    public TextReader(){

    }

    /**
     * Reads in a textfile and adds each line to a HashSet which it returns.
     * @param filename
     * @return HashSet
     */
    public HashSet<String> textFileToSet(String filename) {
        HashSet<String> list = new HashSet<>();
        String line;
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(filename)));
            while((line = br.readLine()) != null) {
                list.add(line);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
