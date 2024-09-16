//{ Driver Code Starts
#include <bits/stdc++.h>

using namespace std;


// } Driver Code Ends
// User function template for C++
class Solution {
  public:

    void rearrange(vector<int> &arr) {
        int n = arr.size();
        vector<int> pos;
        vector<int> neg;
        for(int i=0;i<n;i++){
            if(arr[i]<0){
                neg.push_back(arr[i]);
            }
            else{
                pos.push_back(arr[i]);
            }
        }
       if(pos.size() !=0 && neg.size() !=0){
            arr[0]=pos[0];
        int j=0,i=1;
        int k=1;
       while(i<pos.size() && j<neg.size()){
           arr[k]=neg[j];
           k++;
           j++;
           arr[k]=pos[i];
           i++;
           k++;
       }
       while(i<pos.size()){
           arr[k]=pos[i];
           k++;
           i++;
       }
       while(j<neg.size()){
           arr[k]=neg[j];
           k++;
           j++;
       }
       }
    }
};

//{ Driver Code Starts.

int main() {
    int t;
    cin >> t;
    cin.ignore();
    while (t--) {
        vector<int> arr;
        string input;
        int num;

        getline(cin, input);
        stringstream s2(input);
        while (s2 >> num) {
            arr.push_back(num);
        }
        Solution ob;
        ob.rearrange(arr);
        for (int i = 0; i < arr.size(); i++) {
            cout << arr[i] << " ";
        }
        cout << "\n";
    }
    return 0;
}

// } Driver Code Ends