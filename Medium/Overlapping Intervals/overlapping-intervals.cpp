//{ Driver Code Starts
#include<bits/stdc++.h>
using namespace std;

// } Driver Code Ends
class Solution {
public:
    vector<vector<int>> overlappedInterval(vector<vector<int>>& inter) {
         
         vector<vector<int>> ans;
         
         sort(inter.begin(),inter.end());
         
         ans.push_back({inter[0][0],inter[0][1]});
         
         for(int i=1;i<inter.size();i++)
         {
            
            vector<int> temp=ans.back();
            //ans.pop_back();
            if(temp[1]>=inter[i][0])
            {
                if(temp[1]>=inter[i][1])                //check the temp[0][1]>inter[i][1];
                {
                    continue;
                }
                else
                {
                    temp[1]=inter[i][1];
                    ans.pop_back();                 //update the back element of the ans vector
                    ans.push_back(temp);
                }
            }
            else
            {
                ans.push_back({inter[i][0],inter[i][1]});
            }
         }
         return ans;
    }
};

//{ Driver Code Starts.
int main(){
	int tc;
	cin >> tc;
	while(tc--){
		int n;
		cin >> n;
		vector<vector<int>>Intervals(n);
		for(int i = 0; i < n; i++){
			int x, y;
			cin >> x >> y;
			Intervals[i].push_back(x);
			Intervals[i].push_back(y);
		}
		Solution obj;
		vector<vector<int>> ans = obj.overlappedInterval(Intervals);
		for(auto i: ans){
			for(auto j: i){
				cout << j << " ";
			}
		}
		cout << "\n";
	}
	return 0;
}
// } Driver Code Ends