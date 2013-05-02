import java.util.*;
import java.io.*;

public class Main
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String line = in.readLine();
        StringTokenizer st = new StringTokenizer(line);
        int xMax = Integer.parseInt(st.nextToken());
        int yMax = Integer.parseInt(st.nextToken());
        int[][] grid = new int[xMax][yMax];
    }
}
