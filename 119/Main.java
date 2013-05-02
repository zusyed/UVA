import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String line = "";
        boolean first = true;   // first test case. Used to decide whether to add a newline or not

        while((line=in.readLine()) != null)
        {
            int groupSize = Integer.parseInt(line);
            Map<String, Integer> m = new LinkedHashMap<String, Integer>(groupSize); // person to net gain(or loss)
            StringTokenizer st = new StringTokenizer(in.readLine());
            while(st.hasMoreTokens())
                m.put(st.nextToken(), 0);   // set everyone's net profit to 0

            for(int i=0; i<groupSize; i++)
            {
                st = new StringTokenizer(in.readLine());
                String giver = st.nextToken();  // the person giving the gift
                int amount = Integer.parseInt(st.nextToken());
                int numberOfReceivers = Integer.parseInt(st.nextToken());   // number of people to give gift to
                if(amount > 0 && numberOfReceivers > 0) // to avoid "/ by zero" error
                {
                    int divisibleAmount = amount - (amount % numberOfReceivers);
                    int amountToEach = divisibleAmount/numberOfReceivers;

                    m.put(giver, m.get(giver)-divisibleAmount); // withdraw money from the gift giver
                    while(st.hasMoreTokens())
                    {
                        String reciever = st.nextToken();
                        m.put(reciever, m.get(reciever)+amountToEach);  // add money to reciever
                    }
                }
            }

            if(first)
            {
                first = false;
            }

            else
            {
                out.println();
            }
            for(String s : m.keySet())
                out.printf("%s %d\n", s, m.get(s));
        }
        out.close();
    }
}
