//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.math.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int a[][] = new int[n][2];
            for (int i = 0; i < n; i++) {
                a[i][0] = sc.nextInt();
                a[i][1] = sc.nextInt();
            }
            Solution obj = new Solution();
            int ans = obj.minRemoval(a);
            System.out.println(ans);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static int minRemoval(int intervals[][]) {
        // code here
          if(intervals==null || intervals.length==1){
            return 0;
        }
        
        Arrays.sort(intervals,(a,b)->Integer.compare(a[1],b[1]));
        
        int[] currentInterval = intervals[0];
        int count=0;
        
        for(int i=1;i<intervals.length;i++){
            if(currentInterval[1]>intervals[i][0]){
                count++;
            }else{
                currentInterval=intervals[i];
            }
        }
        return count;
    }
}
