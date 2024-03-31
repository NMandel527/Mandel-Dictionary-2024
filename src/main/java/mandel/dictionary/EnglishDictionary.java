package mandel.dictionary;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Reads the englishDictionary file ONCE.
 */
public class EnglishDictionary {
    private final List<String[]> wordAndDef = new ArrayList<>();

    public EnglishDictionary() throws CsvValidationException, IOException {
        // gets the file from the "resources" directory
        InputStream in = EnglishDictionary.class.getResourceAsStream(
                "/englishDictionary.csv");

        CSVReader reader = new CSVReader(new InputStreamReader(in));
        String[] record;

        while ((record = reader.readNext()) != null) {
            // record is ONE line of the CSV
            wordAndDef.add(record);
        }
        reader.close();
    }

    /**
     * @param word to look up.
     * @return a List of definitions, or an empty list if the word doesn't exist.
     */
    public List<String> getDefinition(String word) {
        List<String> allDefs = new ArrayList<>();

        for (String[] record : wordAndDef) {
            if (record[0].equalsIgnoreCase(word)) {
                allDefs.add(record[2]);
            }
        }
        return allDefs;
    }
}