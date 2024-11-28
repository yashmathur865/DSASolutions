//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
class Solution {
    //28-11-24
  public:
    int myAtoi(char *s) {
        // Your code here
         int n=strlen(s);

        int sign=1;

        int i=0;

       const int MAX=pow(2,31)-1;

       const int MIN=-pow(2,31);

        //ignoring white spaces

        while((i<n)&&(s[i]==' ')){

           i++;

        }

        if((i<n)&&(s[i]=='-'||s[i]=='+')){

            sign=(s[i]=='-')?-1:1;

            i++;

        }

        long long ans=0;

        while(i<n&&s[i]>='0'&&s[i]<='9'){

                ans=ans*10+(s[i]-'0');

                if(sign==-1&&-ans<MIN)return MIN;

                if(sign==1&&ans>MAX)return MAX;

        i++;

        }

        

        return ans*sign;
    }
};

//{ Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        char s[20];
        cin >> s;
        Solution ob;
        int ans = ob.myAtoi(s);
        cout << ans << endl;
        cout << "~" << endl;
    }
}
// } Driver Code Ends