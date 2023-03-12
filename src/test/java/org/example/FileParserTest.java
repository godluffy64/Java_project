package org.example;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.*;

class FileParserTest {
    FileParser fileParserUnderTest;
    @Mock
    Scanner mockScanner;
    @BeforeEach
    public void setup() throws IOException {
        MockitoAnnotations.initMocks(this);
        fileParserUnderTest = new FileParser(mockScanner);
    }
    @Test
    void testFillDictionary()
    {
        Mockito.when(mockScanner.nextLine())
                .thenReturn("Larousse")
                .thenReturn("Bonjour;Hello")
                .thenReturn("Salut;Hello;Hi")
                .thenReturn("a")
                .thenReturn("quatre,four");
        Mockito.when(mockScanner.hasNextLine())
                .thenReturn(true)
                .thenReturn(true)
                .thenReturn(false)
                .thenReturn(true)
                .thenReturn(true);

        fileParserUnderTest.fillDictionary();
        ArrayList<String> traduction_bonjour = new ArrayList<>();
        traduction_bonjour.add("Hello");

        ArrayList <String> traduction_salut = new ArrayList<>();
        traduction_salut.add("Hello");
        traduction_salut.add("Hi");
        assertEquals("Larousse", fileParserUnderTest.getDictionary().getName());
        assertFalse(fileParserUnderTest.getDictionary().isEmpty());
        assertEquals(traduction_bonjour, fileParserUnderTest.getDictionary().getMultipleTranslations("Bonjour"));
        assertEquals(traduction_salut, fileParserUnderTest.getDictionary().getMultipleTranslations("Salut"));
    }
}