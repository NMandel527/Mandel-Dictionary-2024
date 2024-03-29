package mandel.dictionary;

import com.opencsv.exceptions.CsvValidationException;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EnglishDictionaryTest {
    @Test
    public void getDefinition() throws CsvValidationException, IOException{
        //given
        EnglishDictionary dictionary = new EnglishDictionary();

        //when
        List<String> definitions = dictionary.getDefinition("Abnormality");

        //then
        List<String> expectedDef = Arrays.asList("n., The state or quality of being abnormal; variation; irregularity.",
                "n., Something abnormal.");

        assertEquals(expectedDef.toString(), definitions.toString());
    }

}