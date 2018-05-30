/**
 * Node object is used as Node in the linked list class where each Node will
 * have Data and reference to the next Node
 **/
public class Node {
	Node next;
	int data;
	String key;

	public Node(int data, String key) {
		this.data = data;
		this.key = key;
	}
	public String toString() {
		LinkedList l;
		return String.format(" data"+data);
	}
}
