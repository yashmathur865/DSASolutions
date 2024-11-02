//{ Driver Code Starts
import java.util.*;

class MaxLenZeroSumSub
{

    // Returns length of the maximum length subarray with 0 sum

    // Drive method
    public static void main(String arg[])
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0)
        {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            GfG g = new GfG();
            System.out.println(g.maxLen(arr, n));
            T--;
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


class GfG
{
    int maxLen(int arr[], int n)
    {
        // Your code here
         int res=0;
        HashMap<Integer,Integer> h = new HashMap<>();
        int ps=0;
        
        for(int i=0;i<n;i++){
            ps = ps + arr[i];
            if(ps==0){
                res=i+1;
            }
            if(h.containsKey(ps)){
                res=Math.max(res,i-h.get(ps));
            }
            else{
                h.put(ps,i);
            }
        }
        return res;
    }
}