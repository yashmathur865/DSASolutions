//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            // Read first array
            String input = br.readLine();
            String[] inputArray = input.split(" ");
            int[] arr = Arrays.stream(inputArray).mapToInt(Integer::parseInt).toArray();

            Solution ob = new Solution();
            int res = ob.findLongestConseqSubseq(arr);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


class Solution {

    // Function to return length of longest subsequence of consecutive integers.
    public int findLongestConseqSubseq(int[] arr) {
        // code here
        int n = arr.length;
        HashSet<Integer> s = new HashSet<>();
        int res = 1;
        
        for(int i=0;i<n;i++){
            s.add(arr[i]);
        }
        
        for(Integer x : s){
            if(!s.contains(x-1)){
                int curr = 1;
                while(s.contains(x+curr)){
                    curr++;
                    res = Math.max(res,curr);
                }
            }
        }
        return res;
    }
}