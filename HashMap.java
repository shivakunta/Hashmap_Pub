
public class HashMap {
	LinkedList[] array = new LinkedList[10];
	String key;
	String[] keyarr = new String[10];

	public int hashCode(String key) {
		int size = array.length;
		int sum = 0;
		int index;
		for (int i = 0; i <= key.length() - 1; i++) {
			sum = sum + (Character.toString(key.charAt(i))).hashCode();
		}
		index = (sum % size);
		return index;
	}

	public int put(String key, int data) {

		LinkedList l1 = new LinkedList();
		if (keyarr[this.hashCode(key)] == null) {
			keyarr[this.hashCode(key)] = key;
			l1.append(data, key);
			array[this.hashCode(key)] = l1;
		} else {
			l1 = array[this.hashCode(key)];
			if (l1.nodeExist(key)) {
				l1.append(data, key);
			}
		}

		return data;
	}

	public int get(String key) {
		LinkedList ll;
		int data = 0;
		if (keyarr[this.hashCode(key)] != null) {
			ll = array[this.hashCode(key)];
			if (ll.size() >= 1) {
				data = ll.getValue(key);
			}
		}
		return data;
	}

	public static void main(String[] args) {
		HashMap hm = new HashMap();
		hm.put("one", 11);
		hm.put("two", 2);
		hm.put("three", 3);
		hm.put("four", 4);
		hm.put("five", 5);
		
		System.out.println(hm.get("one"));
		
	}
}
