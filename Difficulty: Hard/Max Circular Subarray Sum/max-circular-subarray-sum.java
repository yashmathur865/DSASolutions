//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Sorting {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            System.out.println(new Solution().circularSubarraySum(arr));
            // System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {

    // a: input array
    // n: size of array
    // Function to find maximum circular subarray sum.
    public int normalMaxSum(int a[],int n){
        int res=a[0];
        int maxEnding = a[0];
        for(int i=1;i<n;i++){
            maxEnding = Math.max(a[i],(maxEnding+a[i]));
            res=Math.max(res,maxEnding);
        }
        return res;
    }
    public int circularSubarraySum(int a[]) {
        int n=a.length;
        int maxNormal=normalMaxSum(a,n);
        if(maxNormal<0){
            return maxNormal;
        }
        int aSum=0;
        for(int i=0;i<n;i++){
            aSum=aSum+a[i];
            a[i]=-a[i];
        }
        int maxCircular = aSum + normalMaxSum(a,n);
        return Math.max(maxNormal,maxCircular);
    }
}