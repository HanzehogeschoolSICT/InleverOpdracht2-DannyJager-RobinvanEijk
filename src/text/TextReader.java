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
        try {
            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                list.add(line);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error while reading dictionary");
        }
        return list;
    }

    /**
     * Reads in a textfile and adds each line to a HashSet which it returns.
     * @param filename
     * @return HashSet
     */
    public TreeSet<String> textFileToTreeSet(String filename) {
        TreeSet<String> list = new TreeSet<>();
        try {
            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                list.add(line);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error while reading dictionary");
        }
        return list;
    }

}
