package Model.Game;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.BitSet;

public class BloomFilter {
    BitSet bitArray;
    MessageDigest[] hashFunctions;

    public BloomFilter(int size, String... algNames)
    {
        bitArray = new BitSet(size);
        hashFunctions = new MessageDigest[algNames.length];

        for (int i = 0; i < hashFunctions.length; i++)
        {
            try
            {
                hashFunctions[i] = MessageDigest.getInstance(algNames[i]); //Initializing hash function by its name
            }
            catch (Exception e)
            {
                System.out.println("NoSuchAlgorithmException\n");
            }
        }
    }

    public void add(String word)
    {
        for (int i = 0; i < hashFunctions.length; i++)
        {
            //Switch the bit to 1
            bitArray.set(calcIndexToSwitch(word, hashFunctions[i]));
        }
    }

    public boolean contains(String word)
    {
        for (int i = 0; i < hashFunctions.length; i++)
        {
            //Checks if the bit is off
            if (!bitArray.get(calcIndexToSwitch(word, hashFunctions[i])))
            {
                return false;
            }
        }

        return true;
    }

    private int calcIndexToSwitch(String word, MessageDigest hashFunction)
    {
        byte[] bts = hashFunction.digest(word.getBytes());
        BigInteger number = new BigInteger(bts);
        return Math.abs(number.intValue()) % bitArray.size();
    }
    
    @Override
    public String toString()
    {
        StringBuilder stringBitArray = new StringBuilder();
        for (int i = 0; i < bitArray.length(); i++)
        {
            stringBitArray.append(bitArray.get(i) ? '1' : '0');
        }
        
        return stringBitArray.toString();
    }
}
