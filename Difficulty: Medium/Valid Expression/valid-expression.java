//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while(t-- > 0){
            String S = sc.nextLine().trim();
            Solution ob = new Solution();
            if(ob.valid(S))
                System.out.println(1);
            else
                System.out.println(0);
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    public boolean matching(char a,char b){
        return (a=='(' && b==')' ||
                a=='[' && b==']' ||
                a=='{' && b=='}');
    }
    
    boolean valid(String s) 
    { 
        // code here
        ArrayDeque<Character> st = new ArrayDeque<>();
        for(int i=0;i<s.length();i++){
            char x = s.charAt(i);
            if(x=='(' || x=='[' || x=='{'){
                st.push(x);
            }
            else{
                if(st.isEmpty()==true){
                    return false;
                }
                else if(matching(st.peek(),x)==false){
                    return false;
                }
                else{
                    st.pop();
                }
            }
        }
        return (st.isEmpty()==true);
    }
} 