//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            String line = in.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            int key = Integer.parseInt(in.readLine().trim());

            out.println(new Solution().search(arr, key));

            out.println("~");
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int search(int[] arr, int target) {
        // Complete this function
          int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Check if mid is the target
            if (arr[mid] == target) {
                return mid;
            }

            // Determine which part is sorted
            if (arr[left] <= arr[mid]) { // Left half is sorted
                if (target >= arr[left] && target < arr[mid]) {
                    right = mid - 1; // Target lies in the left half
                } else {
                    left = mid + 1; // Target lies in the right half
                }
            } else { // Right half is sorted
                if (target > arr[mid] && target <= arr[right]) {
                    left = mid + 1; // Target lies in the right half
                } else {
                    right = mid - 1; // Target lies in the left half
                }
            }
        }
        return -1;
    }
}