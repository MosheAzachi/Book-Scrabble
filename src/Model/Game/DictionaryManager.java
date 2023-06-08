package Model.Game;

import java.util.HashMap;

public class DictionaryManager {
    private static DictionaryManager dictionary_manager = null;
    HashMap<String, Dictionary> map;

    private DictionaryManager()
    {
        map = new HashMap<String, Dictionary>();
    }

    public static DictionaryManager get()
    {
        if (dictionary_manager == null)
        {
            dictionary_manager = new DictionaryManager();
        }

        return dictionary_manager;
    }

    public boolean query(String... args)
    {//Checking if the word (last element in args) exists in one of the dictionaries that represents the given files, using quey method
        String word = args[args.length - 1];
        boolean wordExists = false;

        for (int i = 0; i < args.length - 1; i++)
        {
            if (!map.containsKey(args[i]))
            {
                map.put(args[i], new Dictionary(args[i]));
            }
            
            if (map.get(args[i]).query(word))
            {
                wordExists = true;
                //Not returning true because the caches in each dictionary need to be updated (for later searches)
            }
        }

        return wordExists;
    }

    public boolean challenge(String... args)
    {//Checking if the word (last element in args) exists in one of the dictionaries that represents the given files, using challenge method
        String word = args[args.length - 1];
        boolean wordExists = false;

        for (int i = 0; i < args.length - 1; i++)
        {
            if (!map.containsKey(args[i]))
            {
                map.put(args[i], new Dictionary(args[i]));
            }
            
            if (map.get(args[i]).challenge(word))
            {
                wordExists = true;
                //Not returning true because the caches in each dictionary need to be updated (for later searches)
            }
        }

        return wordExists;
    }

    public int getSize()
    {
        return map.size();
    }
}
