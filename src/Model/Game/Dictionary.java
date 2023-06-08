package Model.Game;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Dictionary {
    CacheManager existsWords;
    CacheManager notExistsWords;
    BloomFilter bf;
    String[] fileNames;

    public Dictionary(String... fileNames)
    {
        existsWords = new CacheManager(400, new LRU());
        notExistsWords = new CacheManager(100, new LFU());
        this.fileNames = fileNames;
        bf = new BloomFilter(256, "MD5", "SHA1");

        for (int i = 0; i < fileNames.length; i++)
        {
            addFileWords(fileNames[i]);
        }
    }

    private void addFileWords(String fileName)
    {//Adding all words from the file to the BitSet
        BufferedReader reader = null;
        try
        {
            reader = new BufferedReader(new FileReader(fileName));
            
            String line;
            while ((line = reader.readLine()) != null)
            {
                String[] lineWords = line.split("\\s+");

                for (String word : lineWords)
                {
                    bf.add(word);
                }
            }
            
            reader.close();
        }
        catch (RuntimeException e)
        {
            System.out.println("RunTimeException\n");
        }
        catch (IOException e)
        {
            System.out.println("IOException\n");
        }
    }

    public boolean query(String word)
    {//Checking if the word is in the caches, if not - checking in the BitSet and update the cache according to what was returned
        if (existsWords.query(word))
        {
            return true;
        }
        else if (notExistsWords.query(word))
        {
            return false;
        }

        if (bf.contains(word))
        {
            existsWords.add(word);
            return true;
        }
        
        notExistsWords.add(word);
        return false;
    }

    public boolean challenge(String word)
    {//Checking if the word exists in one of the files
        try 
        {
            if (IOSearcher.search(word, fileNames))
            {
                existsWords.add(word);
                return true;
            }

            notExistsWords.add(word);
            return false;
        }
        catch (Exception e)
        {
            return false;
        }
    }
}
