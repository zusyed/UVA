import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String line = "";   // lines to read in
        Map<String, String> m = new TreeMap<String, String>(); // words to sorted lower case words
        Set<String> anagrams = new HashSet<String>();  // set of all relative anagrams

        while(!(line=in.readLine()).equals("#"))    // The file will be terminated by a line consisting of a single #
        {
            String[] words = line.trim().split(" "); // remove leading and trailing whitespaces, then split by a single space
            for(String word : words)
            {
                char[] chars = word.toLowerCase().toCharArray();
                Arrays.sort(chars);
                String sorted = new String(chars);  // create a new string that is lowercase and sorted. aDCbfe becomes abcdef

                if(!m.containsValue(sorted))
                {
                    m.put(word, sorted);
                }
                else    // it is an anagram
                {
                    anagrams.add(sorted);
                }
            }
        }

        for(String anagram : anagrams)
        {
            while (m.values().remove(anagram)); // remove mappings from m by value. remove all anagrams from m
        }

        for(String ananagram : m.keySet())
        {
            out.println(ananagram); 
        }

        out.close();
    }
}
