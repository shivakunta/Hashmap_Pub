
public class LinkedList {
	static Node head;

	public void append(int data, String key) {
		if (head == null) {
			head = new Node(data, key);
			return;
		}
		Node current = head;
		while (current.next != null) {
			current = current.next;
		}

		current.next = new Node(data, key);
	}

	public void prepend(int data, String key) {
		Node newHead = new Node(data, key);
		newHead.next = head;
		head = newHead;

	}

	public void addNextPosition(int val, int data, String key) {

		if (head == null)
			return;
		if (head.data == val) {
			head.next = new Node(data, key);
			return;
		}

		Node current = head;

		while (current.next != null) {
			if (current.next.data == val) {
				Node temp = current.next.next;
				current.next.next = new Node(data, key);
				current.next.next.next = temp;
			}
			current = current.next;
		}

	}

	public void deleteNode(int data) {

		if (head == null)
			return;
		if (head.data == data) {
			head = head.next;
			return;
		}

		Node current = head;

		while (current.next != null) {
			if (current.next.data == data) {
				current.next = current.next.next;
				return;
			}
			current = current.next;
		}

	}

	public boolean nodeExist(String key) {
		boolean isExists = false;
		if (head == null)
			return isExists;

		if (head.key.equals(key)) {
			isExists = true;
		} else {
			Node current = head;
			while (current.next != null) {
				if (current.next.key.equals(key)) {
					isExists = true;
					break;
				}
				current = current.next;
			}
		}
		return isExists;
	}

	public int getValue(String key) {
		int value = 0;
		if (head == null)
			return value;
		if (head.key == key) {
			return head.data;
		} else {
			Node current = head;
			while (current.next != null) {
				if (current.next.key == key) {
					value = current.next.data;
				}
				current = current.next;
			}
		}
		return value;
	}

	public static String[] getData(LinkedList l) {
		String[] arr = new String[l.size()];
		int k = 0;
		if (head == null)
			return null;
		Node current = head;
		while (current != null) {
			arr[k] = current.key;
			current = current.next;
			k++;
		}

		return arr;
	}

	public int size() {
		int count = 0;
		if (head == null)
			return count;
		Node current = head;

		while (current != null) {

			count++;
			current = current.next;

		}
		return count;
	}

	public static void printArray(String str, String arr[]) {
		int n = arr.length;
		System.out.print(str + " : ");
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	public static void main(String[] args) {

		LinkedList l = new LinkedList();
		l.append(10, "shiva");
		l.append(20, "kumar");
		l.append(30, "charlie");
		l.append(40, "currie");
		l.append(50, "william");
		boolean isthere = l.nodeExist("kunta");
		System.out.println("" + isthere);
		System.out.println("" + l.getValue("shiva"));
		String[] arr = l.getData(l);
		printArray("LINKED LIST CREATED", arr);
		l.deleteNode(10);
		String[] arr1 = l.getData(l);
		printArray("AFTER DELETED", arr1);
		l.addNextPosition(30, 35, "pen");
		String[] arr2 = l.getData(l);
		printArray("AFTER ADD SOMEWHAERE", arr2);

	}
}
