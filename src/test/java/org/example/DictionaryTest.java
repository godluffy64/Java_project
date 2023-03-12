package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class DictionaryTest {
    Dictionary DictionaryUnderTest;

    @BeforeEach
    void setup()
    {
        DictionaryUnderTest = new Dictionary("DictionaryUnderTest");
    }
    @Test
    void testName()
    {
        assertEquals("DictionaryUnderTest", DictionaryUnderTest.getName());
    }
    @Test
    void testIsEmpty()
    {
        assertTrue(DictionaryUnderTest.isEmpty());
    }
    @Test
    void testTranslation()
    {
        String word = "Bonjour";
        ArrayList<String> translation = new ArrayList<>();
        translation.add("Hello");
        DictionaryUnderTest.addTranslation(word, translation);

        assertEquals(translation, DictionaryUnderTest.getTranslation(word));
    }
    @Test
    void testMultipleTranslations()
    {
        String word = "Bonjour";
        ArrayList <String> translations = new ArrayList<>();
        translations.add("Hello");
        translations.add("Hi");
        DictionaryUnderTest.addTranslation(word, translations);
        assertEquals(translations, DictionaryUnderTest.getMultipleTranslations(word));
    }

    @Test
    void testBidirectionality()
    {
        String word_fr = "Bonjour";
        String word_fr2 = "Salut";
        String word_en = "Hello";
        String word_en2 = "Hi";
        ArrayList <String> translations_fr_en = new ArrayList<>();
        translations_fr_en.add(word_en);
        translations_fr_en.add(word_en2);
        ArrayList<String> translations_en_fr = new ArrayList<>();
        translations_en_fr.add(word_fr);
        translations_en_fr.add(word_fr2);
        DictionaryUnderTest.addTranslation(word_fr, translations_fr_en);
        DictionaryUnderTest.addTranslation(word_fr2, translations_fr_en);
        assertEquals(translations_fr_en, DictionaryUnderTest.getMultipleTranslations(word_fr));
        assertEquals(translations_en_fr, DictionaryUnderTest.getMultipleTranslations(word_en));

        String word_fr3 = "Regarder";
        String word_fr4 = "Voir";
        String word_fr5 = "Observer";
        String word_en3 = "Look";
        String word_en4 = "Watch";
        String word_en5 = "Glance";
        String word_en6 = "Stare";
        ArrayList<String> translate_regarder_fr_en = new ArrayList<>();
        Collections.addAll(translate_regarder_fr_en,word_en3,word_en4,word_en5,word_en6);
        ArrayList<String> translate_regarder_en_fr = new ArrayList<>();
        Collections.addAll(translate_regarder_en_fr, word_fr3, word_fr4, word_fr5);
        DictionaryUnderTest.addTranslation(word_fr3, translate_regarder_fr_en);
        DictionaryUnderTest.addTranslation(word_fr3, translate_regarder_fr_en);
        DictionaryUnderTest.addTranslation(word_fr4, translate_regarder_fr_en);
        DictionaryUnderTest.addTranslation(word_fr5, translate_regarder_fr_en);
        assertEquals(translate_regarder_fr_en, DictionaryUnderTest.getMultipleTranslations(word_fr3));
        assertEquals(translate_regarder_en_fr, DictionaryUnderTest.getMultipleTranslations(word_en4));
        assertEquals(translate_regarder_en_fr, DictionaryUnderTest.getMultipleTranslations(word_en5));
        assertEquals(translate_regarder_en_fr, DictionaryUnderTest.getMultipleTranslations(word_en6));

    }
}