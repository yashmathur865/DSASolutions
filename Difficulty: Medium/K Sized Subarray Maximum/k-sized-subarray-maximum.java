//{ Driver Code Starts
// Initial template for JAVA

import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        // taking input using class Scanner
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            // taking total number of elements
            String line = br.readLine();
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
            int k = Integer.parseInt(br.readLine());
            ArrayList<Integer> res = new Solution().max_of_subarrays(arr, k);

            // printing the elements of the ArrayList
            for (int i = 0; i < res.size(); i++) System.out.print(res.get(i) + " ");
            System.out.println();
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function template for JAVA

class Solution {
    //16-11-24
    // Function to find maximum of each subarray of size k.
    public ArrayList<Integer> max_of_subarrays(int arr[], int k) {
        // Your code here
        int n=arr.length;
        Deque<Integer> dq = new LinkedList<Integer>();
        ArrayList<Integer> res = new ArrayList<Integer>();
        
        for(int i=0;i<k;i++){
            while(!dq.isEmpty() && arr[i]>=arr[dq.peekLast()]) {dq.removeLast();}
            dq.addLast(i);
        }
        
        for(int i=k;i<n;i++){
            res.add(arr[dq.peek()]);
            while(!dq.isEmpty() && dq.peek()<=i-k) {dq.removeFirst();}
            while(!dq.isEmpty() && arr[i]>=arr[dq.peekLast()]) {dq.removeLast();}
            dq.addLast(i);
        }
        res.add(arr[dq.peek()]);
        return res;
    }
}