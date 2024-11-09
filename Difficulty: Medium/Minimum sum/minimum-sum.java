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
            int a[] = new int[arr.length];

            for (int i = 0; i < arr.length; i++) {
                a[i] = Integer.parseInt(arr[i]);
            }
            Solution obj = new Solution();
            int f = 0;
            String A = obj.minSum(a);
            System.out.println(A);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
        String minSum(int[] arr) {
        // Sort the array to prepare for partitioning into two numbers
        Arrays.sort(arr);

        // Separate the sorted digits into two parts
        ArrayList<Integer> a1 = new ArrayList<>();
        ArrayList<Integer> a2 = new ArrayList<>();

        int i = 0;
        while (i < arr.length) {
            a1.add(arr[i++]);
            if (i < arr.length) {
                a2.add(arr[i++]);
            }
        }

        // Reverse the lists to start addition from least significant digits
        Collections.reverse(a1);
        Collections.reverse(a2);

        // Prepare for addition of a1 and a2 to calculate the minimum possible sum
        ArrayList<Integer> ans = new ArrayList<>();
        i = 0;
        int j = 0, carry = 0;

        while (i < a1.size() && j < a2.size()) {
            int digit = a1.get(i++) + a2.get(j++) + carry;
            carry = digit / 10;
            digit = digit % 10;
            ans.add(digit);
        }

        // Add remaining digits from a1, if any
        while (i < a1.size()) {
            int digit = a1.get(i++) + carry;
            carry = digit / 10;
            digit = digit % 10;
            ans.add(digit);
        }

        // Add remaining digits from a2, if any
        while (j < a2.size()) {
            int digit = a2.get(j++) + carry;
            carry = digit / 10;
            digit = digit % 10;
            ans.add(digit);
        }

        // Add any remaining carry
        if (carry > 0) {
            ans.add(carry);
        }

        // Reverse the result to get the correct order
        Collections.reverse(ans);

        // Convert to string, skipping leading zeros
        StringBuilder res = new StringBuilder();
        boolean leadingZero = true;
        for (int digit : ans) {
            if (leadingZero && digit == 0) {
                continue;
            }
            leadingZero = false;
            res.append(digit);
        }

        // If res is empty, it means the answer is 0
        return res.length() == 0 ? "0" : res.toString();
    }
    }
