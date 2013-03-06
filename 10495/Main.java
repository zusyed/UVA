import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String line = "";

        while(!(line=in.readLine()).equals("DONE"))
        {
            String alpha = line.replaceAll("[^A-Za-z]","");
            String lowerAlpha = alpha.toLowerCase();
            int middle = lowerAlpha.length()/2;
            boolean palindrome = true;
            for(int i=0,j=lowerAlpha.length()-1; i<middle; i++)
            {
                if(lowerAlpha.charAt(i) != lowerAlpha.charAt(j))
                {
                    out.println("Uh oh..");
                    palindrome = false;
                    break;
                }
                j--;
            }

            if(palindrome)
                out.println("You won't be eaten!");
        }
        out.close();
    }
}
