//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends
class Solution {

    // Function to find a continuous sub-array which adds up to a given number.
    public static ArrayList<Integer> subarraySum(int[] arr, int sum) {
        // Your code here
            int n = arr.length;
        ArrayList<Integer> res = new ArrayList<>();
        HashMap<Integer, Integer> h = new HashMap<>();
        int ps = 0; // Prefix sum
        
        for (int i = 0; i < n; i++) {
            ps += arr[i]; // Update prefix sum
            
            // Check if prefix sum equals the target sum
            if (ps == sum) {
                res.add(1); // Start index
                res.add(i+1); // End index
                return res; // Found subarray from index 0 to i
            }
            
            // If (prefix sum - target sum) exists in the map
            if (h.containsKey(ps - sum)) {
                res.add(h.get(ps - sum) + 1); // Start index (exclusive)
                res.add(i+1); // End index
                return res; // Found subarray
            }
            
            // Store prefix sum with its index
            h.put(ps, i+1);
        }
        
        // If no subarray found, return an empty list
        return res;
    }
}

//{ Driver Code Starts.
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String[] str = br.readLine().trim().split(" ");
            int n = str.length;
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }
            int sum = Integer.parseInt(br.readLine().trim());
            Solution sln = new Solution();
            ArrayList<Integer> list = sln.subarraySum(arr, sum);
            if (list.size() == 0)
                System.out.println("[]");
            else {
                for (int i : list) System.out.print(i + " ");
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends