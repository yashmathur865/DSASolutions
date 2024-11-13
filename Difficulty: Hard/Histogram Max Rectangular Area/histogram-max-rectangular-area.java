//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            long n = Long.parseLong(br.readLine().trim());
            String inputLine[] = br.readLine().trim().split(" ");
            long[] arr = new long[(int)n];
            for (int i = 0; i < n; i++) arr[i] = Long.parseLong(inputLine[i]);
            System.out.println(new Solution().getMaxArea(arr));

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    //13-11-24
    // Function to find the largest rectangular area possible in a given histogram.
    public static long getMaxArea(long hist[]) {
        int n = hist.length;
        ArrayDeque<Integer> s = new ArrayDeque<>();
        long res = 0;

        for (int i = 0; i < n; i++) {
            while (!s.isEmpty() && hist[s.peek()] >= hist[i]) {
                int tp = s.pop();
                long curr = hist[tp] * (s.isEmpty() ? i : (i - s.peek() - 1));
                res = Math.max(res, curr);
            }
            s.push(i);
        }

        // Process remaining elements in the stack
        while (!s.isEmpty()) {
            int tp = s.pop();
            long curr = hist[tp] * (s.isEmpty() ? n : (n - s.peek() - 1));
            res = Math.max(res, curr);
        }

        return res;
    }
}

