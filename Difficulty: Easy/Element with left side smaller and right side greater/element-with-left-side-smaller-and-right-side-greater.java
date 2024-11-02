//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            List<Integer> arr = new ArrayList<>();
            String input = br.readLine();
            StringTokenizer st = new StringTokenizer(input);
            while (st.hasMoreTokens()) {
                arr.add(Integer.parseInt(st.nextToken()));
            }
            Solution ob = new Solution();
            int ans = ob.findElement(arr);
            System.out.println(ans);
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int findElement(List<Integer> arr) {
        // Code here
        int n = arr.size();
        if (n < 3) return -1;

        int res = -1;
        int maxFromLeft[] = new int[n];
        int minFromRight[] = new int[n];
        maxFromLeft[0] = arr.get(0);
        minFromRight[n - 1] = arr.get(n - 1);

        
        for (int i = 1; i < n; i++) {
            maxFromLeft[i] = Math.max(arr.get(i), maxFromLeft[i - 1]);
        }

        for (int i = n - 2; i >= 0; i--) {
            minFromRight[i] = Math.min(arr.get(i), minFromRight[i + 1]);
        }

        for (int i = 1; i < n - 1; i++) {
            if (arr.get(i) >= maxFromLeft[i - 1] && arr.get(i) <= minFromRight[i + 1]) {
                res = arr.get(i);
                break;
            }
        }

        return res;
    }
}