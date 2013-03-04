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
            StringBuilder sb = new StringBuilder(lowerAlpha);
            String reverse = sb.reverse().toString();
            if(lowerAlpha.equals(reverse))
                out.println("You are saved");
            else
                out.println("Uh oh...");
        }
        out.close();
    }
}
