//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            String s;
            s = sc.next();
            
            Solution ob = new Solution();
            char res = ob.firstRep(s);
            if (res == '#')
                System.out.println(-1);
            else
                System.out.println(res);
             
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution
{   
    static final int CHAR=256;
    char firstRep(String S)
    {
        boolean []visited = new boolean[CHAR];
        char res = '#';
        for(int i=S.length()-1;i>=0;i--){
            if(visited[S.charAt(i)]){
                res=S.charAt(i);
            }
            else{
                visited[S.charAt(i)] = true;
            }
        }
        return res;
    }
}