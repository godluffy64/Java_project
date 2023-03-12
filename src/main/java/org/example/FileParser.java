package org.example;
import java.util.ArrayList;
import java.util.Scanner;
public class FileParser
{
    private Scanner scanner;
    private Dictionary dictionary;
    public FileParser(Scanner sc)
    {
        this.scanner = sc;
    }
    public Dictionary getDictionary() {
        return this.dictionary;
    }
    public void fillDictionary()
    {
        String line;
        String list[];
        boolean first_word = true;
        dictionary = new Dictionary(scanner.nextLine());

        while(scanner.hasNextLine())
        {
            ArrayList <String> traduction = new ArrayList<>();
            line = scanner.nextLine();
            list = line.split(";");
            if (list.length >= 2)
            {
                String word = list[0];
                for (String trad : list)
                {
                    if (!first_word)  traduction.add(trad);
                    else first_word = false;
                }
                getDictionary().addTranslation(word, traduction);
                first_word = true;
            }

        }
        scanner.close();
    }
}
