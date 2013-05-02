import java.util.*;
import java.io.*;

public class Main
{
    static boolean[] visited;

    public static void main(String[] args) throws Exception
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String l = "";

        while (!(l=in.readLine()).equals("0"))
        {
        int nVertices = Integer.parseInt(l);
        int nEdges = Integer.parseInt(in.readLine());
        Map<Integer, ArrayList<Integer>> myGraph = new HashMap<Integer, ArrayList<Integer>>();
        for(int i=0; i<nEdges; i++)
        {
            String line = in.readLine();
            StringTokenizer st = new StringTokenizer(line);
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if(myGraph.containsKey(x))
                myGraph.get(x).add(y);
            else
            {
                myGraph.put(x, new ArrayList<Integer>());
                myGraph.get(x).add(y);
            }
        }

        visited = new boolean[nVertices + 1];  // by default, all are false
//
//        for(int i = 0; i < nVertices; i++)
//        {
//            if(!visited[i])
//            {
//                if(dfs(myGraph, 0) == 1)
                //System.out.println("sdfsaf " +dfs(myGraph, 0));
                //dfs(myGraph, 0);
                if(dfs(myGraph, 0))
                    out.println("BICOLORABLE");
                else
                    out.println("NOT BICOLORABLE");
//                {
//                    System.out.println("not");
//                }
//            }
//        }

//                else
//        out.println("biColorable");
        }

        out.close();
    }

    public static boolean dfs(Map<Integer, ArrayList<Integer>> g, int node)
    {
        //Queue<Integer> q = new LinkedList<Integer>();
        Stack<Integer> q = new Stack<Integer>();
        visited[node] = true;  // set it to true
        q.push(node);
/*
        if (g.get(node) == null)
            return;
            */

        while(q.size() > 0)     // while q is not empty
        {
            int x = q.pop();
            //System.out.println(x);

            if (g.get(x) == null)
                continue;

            for(int v : g.get(x))    // for every neighbour v of x
            {
                if(!visited[v])
                {
                    visited[v] = true;
                    q.push(v);
                }
                else
                {
                    return false;
                }
            }
            visited[x] = true;
        }
                    return true;
    }
}
