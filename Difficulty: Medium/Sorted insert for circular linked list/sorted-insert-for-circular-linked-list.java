//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

public class GFG {
    static void printList(Node head) {
        if (head == null) return;

        Node temp = head;
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != head);

        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String input = br.readLine();
            StringTokenizer st = new StringTokenizer(input);
            ArrayList<Integer> arr = new ArrayList<>();
            while (st.hasMoreTokens()) {
                arr.add(Integer.parseInt(st.nextToken()));
            }
            int x = Integer.parseInt(br.readLine());
            Node head = new Node(arr.get(0));
            Node tail = head;
            for (int i = 1; i < arr.size(); ++i) {
                tail.next = new Node(arr.get(i));
                tail = tail.next;
            }
            tail.next = head; // Make it circular
            Solution ob = new Solution();
            Node ans = ob.sortedInsert(head, x);
            printList(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    public Node sortedInsert(Node head, int data) {
        // code here
        Node temp = new Node(data);
        if(head==null){
            temp.next=temp;
            return temp;
        }
        if(data<=head.data){
            temp.next=head.next;
            head.next=temp;
            int t=head.data;
            head.data=temp.data;
            temp.data=t;
            return head;
        }
        else{
            Node curr = head;
            while(curr.next!=head && curr.next.data < data){
                curr=curr.next;
            }
            temp.next=curr.next;
            curr.next=temp;
        }
        return head;
    }
}