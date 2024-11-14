//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {

            ArrayList<Integer> array1 = new ArrayList<Integer>();
            String line = read.readLine();
            String[] tokens = line.split(" ");
            for (String token : tokens) {
                array1.add(Integer.parseInt(token));
            }
            ArrayList<Integer> v = new ArrayList<Integer>();
            int[] arr = new int[array1.size()];
            int idx = 0;
            for (int i : array1) arr[idx++] = i;

            v = new Solution().modifyAndRearrangeArr(arr);

            for (int i = 0; i < v.size(); i++) System.out.print(v.get(i) + " ");

            System.out.println();
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    //14-11-24
    static ArrayList<Integer> modifyAndRearrangeArr(int arr[]) {
        // Complete the function
         ArrayList<Integer> res = new ArrayList<>();
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            if (arr[i] != 0) {
                if (i < n - 1 && arr[i] == arr[i + 1]) {
                    res.add(2 * arr[i]);
                    arr[i + 1] = 0;
                } else {
                    res.add(arr[i]);
                }
            }
        }
        while (res.size() < n) {
            res.add(0);
        }

        return res;
    }
}