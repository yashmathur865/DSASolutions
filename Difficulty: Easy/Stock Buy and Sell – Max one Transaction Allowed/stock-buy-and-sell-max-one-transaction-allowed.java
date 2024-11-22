//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String arr[] = br.readLine().split(" ");
            int prices[] = new int[arr.length];

            for (int i = 0; i < arr.length; i++) {
                prices[i] = Integer.parseInt(arr[i]);
            }
            Solution obj = new Solution();
            int res = obj.maximumProfit(prices);
            System.out.println(res);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    //22-11-24
    public int maximumProfit(int arr[]) {
        // Code here
        int n=arr.length;
        int res=0;
        int min=arr[0];
        for(int i=0;i<n;i++){
            if(arr[i]>min){
                res=Math.max(res,arr[i]-min);
            }
            if(arr[i]<min){
                min=arr[i];
            }
        }
        return res;
    }
}