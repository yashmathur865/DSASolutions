//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String[] arr1Str = sc.nextLine().split(" ");
            int[] arr = Arrays.stream(arr1Str).mapToInt(Integer::parseInt).toArray();
            Solution ob = new Solution();
            int ans = ob.getSecondLargest(arr);
            System.out.println(ans);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    //15-11-24
    public int getSecondLargest(int[] arr) {
        // Code Here
        int n = arr.length;
        int largest = arr[0];
        int slargest = -1;
        for(int i=1;i<n;i++){
            if(arr[i]>largest){
                slargest = largest;
                largest=arr[i];
            }
            if(arr[i]<largest && arr[i]>slargest){
                    slargest=arr[i];
            }
        }
        return slargest;
    }
}