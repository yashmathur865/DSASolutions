//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
/*
The structure of the class is as follows
class _stack{
stack<int> s;
int minEle;
public :
    int getMin();
    int pop();
    void push(int);
};
*/

class Solution{
    int minEle;
    stack<int> s1; // Main stack for all elements
    stack<int> s2; // Auxiliary stack for tracking minimum elements
public:
    
    /* returns minimum element from stack */
    int getMin() {
        if (s2.empty()) return -1;
        return s2.top();
    }
    
    /* pops the top element from stack */
    int pop() {
        if (s1.empty()) return -1;
        
        int x = s1.top();
        s1.pop();
        
        // If popping the element that is currently the minimum, pop it from s2 as well
        if (x == s2.top()) {
            s2.pop();
        }
        
        return x;
    }
    
    /* pushes an element x into the stack */
    void push(int x) {
        s1.push(x);
        
        // If s2 is empty or x is the new minimum, push it onto s2
        if (s2.empty() || x <= s2.top()) {
            s2.push(x);
        }
    }
};


//{ Driver Code Starts.

int main()
 {
    long long t;

    cin>>t;
    while(t--)
    {
        int q;
        cin>>q;
        Solution ob;
        while(q--){
           int qt;
           cin>>qt;
           if(qt==1)
           {
              //push
              int att;
              cin>>att;
              ob.push(att);
           }
           else if(qt==2)
           {
              //pop
              cout<<ob.pop()<<" ";
           }
           else if(qt==3)
           {
              //getMin
              cout<<ob.getMin()<<" ";
           }
       }
       cout<<endl;
    
cout << "~" << "\n";
}
    return 0;
}

// } Driver Code Ends