//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int x = Integer.parseInt(br.readLine());
            String[] input = br.readLine().split(" ");
            int[] arr = new int[input.length];
            for (int i = 0; i < input.length; i++) {
                arr[i] = Integer.parseInt(input[i]);
            }

            Solution ob = new Solution();
            int[] ans = ob.getFloorAndCeil(x, arr);
            System.out.println(ans[0] + " " + ans[1]);
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int[] getFloorAndCeil(int x, int[] arr) {
        // code here
        int n = arr.length;
        int floor = -1;
        int ceil = -1;
        int res[] = new int[2];
        
        for(int i=0;i<n;i++){
            if(arr[i]<=x && arr[i] > floor){
                floor = arr[i];
            }
            if(arr[i]>=x && (ceil == -1 || arr[i] < ceil)){
                ceil = arr[i];
            }
        }
        res[0] = floor;
        res[1] = ceil;
        return res;
    }
}
