//{ Driver Code Starts
#include <bits/stdc++.h>

using namespace std;


// } Driver Code Ends
// User function template for C++
class Solution {
  public:
    int findKRotation(vector<int> &arr) {
        // Code Here
         int n=arr.size();
    int low=0;
    int high=n-1;
    int ans=arr[0];
    int r=0;
    while(low<=high){
        int mid=low+(high-low)/2;
                if (arr[low] <= arr[mid]) {
                    ans=min(ans,arr[low]);
                    if(ans==arr[low]) r=low;
                    low=mid+1;

                }else{
                    ans=min(ans,arr[mid]);
                    if(ans==arr[mid]) r=mid;
                    high=mid-1;
                }
        }return r;
    }
};


//{ Driver Code Starts.

int main() {
    int t;
    cin >> t;
    cin.ignore();
    while (t--) {
        vector<int> arr;
        string input1;
        getline(cin, input1);
        stringstream ss1(input1);
        int number1;
        while (ss1 >> number1) {
            arr.push_back(number1);
        }
        Solution ob;
        int res = ob.findKRotation(arr);
        cout << res << endl;
    }
}
// } Driver Code Ends