//{ Driver Code Starts
// Initial template for C++

#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
// User function template for C++

class Solution {
  public:
    // nums: given vector
    // return the Product vector P that hold product except self at each index
    vector<long long int> productExceptSelf(vector<long long int>& arr) {

        // code here
        int n = arr.size();
        vector<long long int> result(n, 0);
        long long int totalProduct = 1;
        int zeroCount = 0;
        
        for(int i = 0; i < n; i++) {
            if(arr[i] == 0) {
                zeroCount++;
            } else {
                totalProduct *= arr[i];
            }
        }
        
        if(zeroCount > 1) {
            // All products will be zero
            return result; // Already initialized with zeros
        } else if(zeroCount == 1) {
            // Only one element will have non-zero product
            for(int i = 0; i < n; i++) {
                if(arr[i] == 0) {
                    result[i] = totalProduct;
                }
            }
        } else {
            // No zeros, proceed with division
            for(int i = 0; i < n; i++) {
                result[i] = totalProduct / arr[i];
            }
        }

        return result;
    }
};


//{ Driver Code Starts.
int main() {
    int t; // number of test cases
    cin >> t;
    while (t--) {
        int n; // size of the array
        cin >> n;
        vector<long long int> arr(n), vec(n);

        for (int i = 0; i < n; i++) // input the array
        {
            cin >> arr[i];
        }
        Solution obj;
        vec = obj.productExceptSelf(arr); // function call

        for (int i = 0; i < n; i++) // print the output
        {
            cout << vec[i] << " ";
        }
        cout << endl;
    }
    return 0;
}
// } Driver Code Ends