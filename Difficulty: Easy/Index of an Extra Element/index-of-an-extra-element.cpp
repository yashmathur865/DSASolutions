//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
class Solution {
  public:
    int findExtra(int n, int arr1[], int arr2[]) {
        // add code here.
        // Adjust high to n-2 because arr2 has n-1 elements
    int low = 0, high = n - 2;

    while (low <= high) {
        int mid = low + (high - low) / 2;
        
        // If there's a mismatch at mid and no mismatch before mid
        if (arr1[mid] != arr2[mid]) {
            if (mid == 0 || arr1[mid - 1] == arr2[mid - 1]) {
                return mid;
            }
            high = mid - 1;
        } 
        else {
            low = mid + 1;
        }
    }
    
    // If no mismatch found in the middle, extra element is at the end
    return n - 1;
    }
};

//{ Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        int n;
        cin >> n;
        int arr1[n], arr2[n - 1];
        for (int i = 0; i < n; i++) {
            cin >> arr1[i];
        }
        for (int i = 0; i < n - 1; i++) {
            cin >> arr2[i];
        }
        Solution obj;
        cout << obj.findExtra(n, arr1, arr2) << endl;
    
cout << "~" << "\n";
}
}
// } Driver Code Ends