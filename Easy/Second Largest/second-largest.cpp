//{ Driver Code Starts
#include <bits/stdc++.h>

using namespace std;

// } Driver Code Ends
//User function template for C++
class Solution{
public:	
	// Function returns the second
	// largest elements
	int print2largest(int arr[], int n) {
	    int sl = -1;
	    int l=0;
	    for(int i=1;i<n;i++){
	        if(arr[i]>arr[l]){
	            l=i;
	        }
	    }
	    
	    int largest = l;
	    for(int i=1;i<n;i++){
	        if(arr[i]>arr[largest]){
	            sl = largest;
	            largest=i;
	        }
	        if(arr[i]!=arr[largest]){
	            if(sl == -1 || arr[i]>arr[sl]){
	                sl=i;
	            }
	        }
	    }
	    if(sl == -1){
	        return -1;
	    }
	    else{
	        return arr[sl];
	    }
	    
	}
};

//{ Driver Code Starts.

int main() {
    int t;
    cin >> t;
    while (t--) {
        int n;
        cin >> n;
        int arr[n];
        for (int i = 0; i < n; i++) {
            cin >> arr[i];
        }
        Solution ob;
        auto ans = ob.print2largest(arr, n);
        cout << ans << "\n";
    }
    return 0;
}

// } Driver Code Ends