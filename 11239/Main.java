import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String line = "";   // next line to read from input
        Map<String, Set<String>> m = new HashMap<String, Set<String>>();    // map projects to set of userID of students
        String project = "";    // projects start with capital
        ArrayList<String> ban = new ArrayList<String>();    // list of students who signed up for multiple projects

        while((line=in.readLine()).charAt(0)!= '0')  // The last test case is followed by a line starting with the digit 0
        {
            if(line.charAt(0) == ('1')) // The input contains several test cases, each one ending with a line that starts with the digit 1
            {                           
                for(String projectSheet : m.keySet())
                {
                    for(String b : ban)
                        m.get(projectSheet).remove(b);   // remove all userIDs from the map that are in the ban list
                }

                ArrayList<ProjectToCount> ptcs = new ArrayList<ProjectToCount>(m.size());

                for(String key : m.keySet())
                {
                    ptcs.add(new ProjectToCount(key, m.get(key).size()));
                }

                Collections.sort(ptcs);
//                Collections.reverse(ptcs);

                for(ProjectToCount ptc : ptcs)
                {
                    out.printf("%s %d\n", ptc.project, ptc.count);
                }
/*
                for(String key : m.keySet())
                {
                    out.println(key);
                    for(String value : m.get(key))
                    {
                        out.println(value);
                    }
                }
                */
                m.clear();
                continue;
            }

            if(isUpper(line))
            {
                project = line; // projects are uppercased
                m.put(project, new HashSet<String>());  // create a new set of userID for each project
            }
            else    // userIDs are lowercased
            {
                for(String key : m.keySet())
                {
                    if(m.get(key).contains(line) && !key.equals(project))   // if the current userID exists in the set which is not in the current project
                    {
                        ban.add(line);  // add the userID to the ban list
                    }
                }
                m.get(project).add(line);   // add the userID (which is not already signed up for a different project) to the project
            }
        }
        out.close();
    }

    public static boolean isUpper(String str)
    {
        String s = str.replaceAll(" ", ""); // trim all whitespaces
        for(char c : s.toCharArray())
        {
            if(!Character.isUpperCase(c))
                return false;
        }

        return true;
    }
}

class ProjectToCount implements Comparable<ProjectToCount>
{
    String project;
    Integer count;
    public ProjectToCount(String project, Integer count)
    {
        this.project = project;
        this.count = count;
    }

    public int compareTo(ProjectToCount other)
    {
        int c = other.count.compareTo(this.count);
        return c == 0 ? this.project.compareTo(other.project) : c;
    }
}
