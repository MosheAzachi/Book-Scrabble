package Model.Game;

import java.util.HashSet;

public class CacheManager {
    int maxSize;
    CacheReplacementPolicy crp;
    HashSet<String> words;

    public CacheManager(int size, CacheReplacementPolicy crp)
    {
        this.maxSize = size;
        this.crp = crp;
        words = new HashSet<>();
    }

    public boolean query(String word)
    {
        return words.contains(word);
    }

    public void add(String word)
    {
        crp.add(word);
        words.add(word);
        
        if (words.size() > maxSize)
        {
            words.remove(crp.remove());
        }
    }
}
