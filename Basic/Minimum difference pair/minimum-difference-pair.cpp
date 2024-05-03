//{ Driver Code Starts
#include<bits/stdc++.h>
using namespace std;

// } Driver Code Ends
class Solution{
	public:
   	int  minimum_difference(vector<int>arr){
   	    int n=arr.size();
   	    sort(arr.begin(), arr.end()); 
   	    int res=INT_MAX;
   	    for(int i=1;i<n;i++){
   	        res=min(res,(arr[i]-arr[i-1]));
   	    }
   	    return res;
   	}    
};

//{ Driver Code Starts.
int main(){
	int tc;
	cin >> tc;
	while(tc--){
		int n;
		cin >> n;
		vector<int>nums(n);
		for(int i = 0; i < nums.size(); i++)cin >> nums[i];
		Solution ob;
		int ans = ob.minimum_difference(nums);
		cout << ans <<"\n";
	}  
	return 0;
}
// } Driver Code Ends