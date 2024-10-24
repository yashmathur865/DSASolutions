//{ Driver Code Starts
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        while (t-- > 0) {
            String[] arr1Str = sc.nextLine().trim().split(" ");
            String[] arr2Str = sc.nextLine().trim().split(" ");
            int n = arr1Str.length;
            int[] arr1 = new int[n];
            int[] arr2 = new int[n];

            for (int i = 0; i < n; i++) {
                arr1[i] = Integer.parseInt(arr1Str[i]);
                arr2[i] = Integer.parseInt(arr2Str[i]);
            }

            Solution sol = new Solution();
            int result = sol.longestCommonSum(arr1, arr2);
            System.out.println(result);
        }

        sc.close();
    }
}
// } Driver Code Ends



class Solution {
    public int longestCommonSum(int[] arr1, int[] arr2) {
        // Your code goes here
        
        int n = arr1.length;
        int[] temp = new int[n];
        for(int i=0;i<n;i++){
            temp[i] = arr1[i] - arr2[i];
        }
        
        //Mow we will just need to find Longest subarray with 0 sum in temp
        HashMap<Integer,Integer> h = new HashMap<>();
        int ps = 0;
        int res = 0;
        for(int i=0;i<n;i++){
            ps += temp[i];
            if(ps == 0){
                res = i+1;
            }
            if(h.containsKey(ps)){
                res = Math.max(res,i-h.get(ps));
            }
            else{
                h.put(ps,i);
            }
        }
        return res;
    }
}