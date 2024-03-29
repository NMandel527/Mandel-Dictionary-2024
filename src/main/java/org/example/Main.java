package org.example;

import com.opencsv.exceptions.CsvValidationException;
import mandel.dictionary.EnglishDictionary;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws CsvValidationException, IOException {
        EnglishDictionary dict = new EnglishDictionary();
        System.out.println(dict.getDefinition("Aboriginal"));
    }
}