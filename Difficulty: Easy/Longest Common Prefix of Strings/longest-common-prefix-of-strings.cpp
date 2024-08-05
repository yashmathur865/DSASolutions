//{ Driver Code Starts
// Initial template for C++

#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
// User function template for C++

class Solution {
  public:

    string longestCommonPrefix(vector<string> strs) {
        // your code here
        string common = strs[0];
        for(string s : strs)
        {
           for(int i = 0 ; i<common.size() ; i++)
           {
            if(s[i]!=common[i])  common.erase(i,common.size()-i+1);
           }
        }

        if(common.size() == 0) return "-1";
        else return common;
    }
};

//{ Driver Code Starts.
int main() {
    int t;
    cin >> t;
    cin.ignore();
    while (t--) {
        vector<string> arr;
        string input;
        getline(cin, input);
        stringstream ss(input);
        string number;
        while (ss >> number) {
            arr.push_back(number);
        }

        Solution ob;
        cout << ob.longestCommonPrefix(arr) << endl;
    }
}

// } Driver Code Ends