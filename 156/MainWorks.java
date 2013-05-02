import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String line = "";   // lines to read in
        Map<String, String> m = new TreeMap<String, String>(); // word to their relative anagrams
        Set<String> s = new HashSet<String>();

        while(!(line=in.readLine()).equals("#"))    // The file will be terminated by a line consisting of a single #
        {
            String[] words = line.split("[ ]+");
            for(String word : words)
            {
                char[] chars = word.toLowerCase().toCharArray();
                Arrays.sort(chars);
                String sorted = new String(chars);

                if(!m.containsValue(sorted))
                {
                    out.printf("%s %s\n",word,sorted);
                    m.put(word, sorted);
                }
                else
                {
                    out.printf("%s already contains: %s\n",word,sorted);
                    s.add(sorted);
                }
            }
        }

        for(String str : s)
        {
            out.println("set: "+str);
            while (m.values().remove(str));
        }

        for(String str : m.keySet())
        {
            out.println(str);
        }

        out.close();
    }
}
