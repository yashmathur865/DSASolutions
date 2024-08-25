//{ Driver Code Starts
#include<bits/stdc++.h> 
using namespace std;

// } Driver Code Ends
class Solution{
public:
    int evenlyDivides(int n){
        
        int number = n;
        int count=0;
        while(n>0){
            int last_digit = n%10;
            if(last_digit!=0 && number%last_digit == 0){
                count++;
            }
            n=n/10;
        }
        
        return count;
    }
};

//{ Driver Code Starts.
int main() 
{ 
    int t;
    cin>>t;
    while(t--)
    {
        int N;
        cin>>N;
        Solution ob;
        cout << ob.evenlyDivides(N) << endl;
    }
    return 0; 
}
// } Driver Code Ends