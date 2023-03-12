package org.example;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.File;
import java.util.Scanner;

public class Dictionary {
    private String name;
    private HashMap<String, ArrayList<String>> translation_fr_to_en;
    private HashMap<String, ArrayList<String>> translation_en_to_fr;
    public Dictionary(String n)     // constructeur avec nom
    {
        this.name = n;
        translation_fr_to_en = new HashMap<>();
        translation_en_to_fr = new HashMap<>();
    }

    public String getName()
    {
        return this.name;
    }
    public boolean isEmpty()
    {
        return translation_fr_to_en.isEmpty();
    }

    public void addTranslation(String fr, ArrayList en)
    {
        if(!translation_fr_to_en.containsKey(fr))  translation_fr_to_en.put(fr, en);
        ArrayList<String> french = new ArrayList<>();
        french.add(fr);
        for(int i  = 0; i < en.size(); i++)
        {
            if(!translation_en_to_fr.containsKey(en.get(i)))
            {
                    translation_en_to_fr.put((String) en.get(i), french);
            }
            else if (!translation_en_to_fr.get(en.get(i)).contains(fr))
            {
                translation_en_to_fr.get(en.get(i)).add(fr);
            }
        }
    }

    public ArrayList getTranslation(String word)
    {
        if (translation_fr_to_en.containsKey(word)) return translation_fr_to_en.get(word);
        return null;
    }

    public ArrayList getMultipleTranslations(String word)
    {
        if (translation_fr_to_en.containsKey(word))
        {
            return  translation_fr_to_en.get(word);
        }
        else if (translation_en_to_fr.containsKey(word))
        {
            return translation_en_to_fr.get(word);
        }
        return null;
    }

    public void FillDictionary(String id) throws IOException
    {
        File file = new File("Text.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        String list[];
        line = br.readLine();
        while (line != null)
        {
            list = line.split(",");
        }
    }
}

