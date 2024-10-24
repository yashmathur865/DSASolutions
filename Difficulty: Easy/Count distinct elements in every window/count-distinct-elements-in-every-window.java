//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.util.HashMap;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            // taking total number of elements
            int k = Integer.parseInt(br.readLine());
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
            ArrayList<Integer> ans = new Solution().countDistinct(k, arr);

            for (Integer val : ans) System.out.print(val + " ");
            System.out.println();
            t--;
        }
    }
}
// } Driver Code Ends


class Solution {
    ArrayList<Integer> countDistinct(int k, int arr[]) {
        // code here
        int n = arr.length;
        ArrayList<Integer> res = new ArrayList<>();
        HashMap<Integer,Integer> h = new HashMap<>();
        
        for(int i=0;i<k;i++){
            h.put(arr[i],h.getOrDefault(arr[i],0)+1);
        }
        res.add(h.size());
        
        for(int i=k;i<n;i++){
            h.put(arr[i-k],h.get(arr[i-k]) - 1);
            
            if(h.get(arr[i-k]) == 0){
                h.remove(arr[i-k]);
             }
           
            h.put(arr[i],h.getOrDefault(arr[i],0)+1);
            res.add(h.size());
        }
        return res;
    }
}
