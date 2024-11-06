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


// } Driver Code Ends
// User function Template for Java

/*class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
    */
class Solution {
    
     public static Node sortedInsert(Node sortedHead, Node newNode) {
        if (sortedHead == null || newNode.data < sortedHead.data) {
            newNode.next = sortedHead;
            return newNode;
        }

        Node curr = sortedHead;
        while (curr.next != null && curr.next.data < newNode.data) {
            curr = curr.next;
        }

        newNode.next = curr.next;
        curr.next = newNode;
        return sortedHead;
    }
    
    public static Node insertionSort(Node head) {
        // code here
        Node sortedHead = null; // Start with an empty sorted list
        Node curr = head;

        while (curr != null) {
            Node next = curr.next; // Saving the next node
            sortedHead = sortedInsert(sortedHead, curr); // Inserting current node in sorted order
            curr = next;
        }

        return sortedHead;
    }
}

//{ Driver Code Starts.

class GFG {
    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            List<Integer> arr = new ArrayList<>();
            String input = br.readLine().trim();
            StringTokenizer st = new StringTokenizer(input);
            while (st.hasMoreTokens()) {
                arr.add(Integer.parseInt(st.nextToken()));
            }

            Node head = null;
            if (!arr.isEmpty()) {
                head = new Node(arr.get(0));
                Node tail = head;
                for (int i = 1; i < arr.size(); i++) {
                    tail.next = new Node(arr.get(i));
                    tail = tail.next;
                }
            }
            head = new Solution().insertionSort(head);
            printList(head);
        
System.out.println("~");
}
    }
}

// } Driver Code Ends