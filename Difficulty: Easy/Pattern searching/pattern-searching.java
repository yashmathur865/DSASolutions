//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            String str;
            str = br.readLine();
            
            
            String pat;
            pat = br.readLine();
            
            Solution obj = new Solution();
            boolean res = obj.searchPattern(str, pat);
            
            if(res)
            System.out.println("Present");
            else
            System.out.println("Not present");
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


class Solution {
    public static boolean searchPattern(String str, String pat) {
        // code here
        int n = str.length();
        int m = pat.length();
        int j;
        for(int i=0;i<=n-m;i++){
            for(j=0;j<m;j++){
                if(str.charAt(i+j) != pat.charAt(j)){
                    break;
                }
            }
            if(j==m){
                return true;
            }
        }
        return false;
    }
}
        
