//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
class Solution
{
    public:
    //Function to check if a string can be obtained by rotating
    //another string by exactly 2 places.
    bool isRotated(string str1, string str2)
    {
        // Your code here
         int n1 = str1.size(), n2 = str2.size();
        
        if(n1!=n2) return false;
        
        if(n1 <= 2) return (str1 == str2);
        
        string l2 = str1.substr(n1-2);
        string f2 = str1.substr(0,2);
        
        if(str2.compare(n2-2,2,f2)==0)
            if(str2.compare(0,n2-2,str1,2,n1-2)==0) return true;
            
        if(str2.compare(0,2,l2)==0)
            if(str2.compare(2,n2-2,str1,0,n1-2)==0) return true;
        
        return false;
    }

};


//{ Driver Code Starts.

int main() {
	
	int t;
	cin>>t;
	while(t--)
	{
		string s;
		string b;
		cin>>s>>b;
		Solution obj;
		cout<<obj.isRotated(s,b)<<endl;
	}
	return 0;
}

// } Driver Code Ends