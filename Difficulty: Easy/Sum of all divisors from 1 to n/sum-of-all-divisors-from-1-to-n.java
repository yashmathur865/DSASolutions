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
            int N=sc.nextInt();
            Solution ob = new Solution();
            long ans  = ob.sumOfDivisors(N);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution{
    static long sumOfDivisors(int n){
        // code here
         long result = 0;
        
        // Loop over each potential divisor
        for(int i = 1; i <= n; i++) {
            // Add i to the sum for every number that is a multiple of i
            result += (n / i) * i;
        }
        
        return result;
    }
}