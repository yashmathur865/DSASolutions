//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

public class LRUDesign {

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {

            int capacity = Integer.parseInt(read.readLine());
            int queries = Integer.parseInt(read.readLine());
            LRUCache cache = new LRUCache(capacity);
            String str[] = read.readLine().trim().split(" ");
            int len = str.length;
            int itr = 0;

            for (int i = 0; (i < queries) && (itr < len); i++) {
                String queryType = str[itr++];
                if (queryType.equals("SET")) {
                    int key = Integer.parseInt(str[itr++]);
                    int value = Integer.parseInt(str[itr++]);
                    cache.set(key, value);
                }
                if (queryType.equals("GET")) {
                    int key = Integer.parseInt(str[itr++]);
                    System.out.print(cache.get(key) + " ");
                }
            }
            System.out.println();

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// design the class in the most optimal way

class Node { 
	int key; 
	int value; 
	Node pre; 
	Node next; 

	public Node(int key, int value) 
	{ 
		this.key = key; 
		this.value = value; 
	} 
} 

class LRUCache {
    private HashMap<Integer, Node> map; 
	private int capacity, count; 
	private Node head, tail;
	
    // Constructor for initializing the cache capacity with the given value.
    LRUCache(int capacity) {
        // code here
        this.capacity = capacity; 
		map = new HashMap<>(); 
		head = new Node(0, 0); 
		tail = new Node(0, 0); 
		head.next = tail; 
		tail.pre = head; 
		head.pre = null; 
		tail.next = null; 
		count = 0;
    }
    
    public void deleteNode(Node node) 
	{ 
		node.pre.next = node.next; 
		node.next.pre = node.pre; 
	} 

	public void addToHead(Node node) 
	{ 
		node.next = head.next; 
		node.next.pre = node; 
		node.pre = head; 
		head.next = node; 
	} 

    // Function to return value corresponding to the key.
    public int get(int key) {
        // your code here
        	if (map.get(key) != null) { 
			Node node = map.get(key); 
			int result = node.value; 
			deleteNode(node); 
			addToHead(node); 
			
			return result; 
		} 
		return -1; 
    }

    // Function for storing key-value pair.
    public void set(int key, int value) {
        // your code here
        	if (map.get(key) != null) { 
			Node node = map.get(key); 
			node.value = value; 
			deleteNode(node); 
			addToHead(node); 
		} 
		else { 
			Node node = new Node(key, value); 
			map.put(key, node); 
			if (count < capacity) { 
				count++; 
				addToHead(node); 
			} 
			else { 
				map.remove(tail.pre.key); 
				deleteNode(tail.pre); 
				addToHead(node); 
			} 
		} 
    }
}
