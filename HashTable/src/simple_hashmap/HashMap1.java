package simple_hashmap;

class Entry {
	int key;
	int value;
	Entry(int key, int value) {
		this.key = key;
		this.value = value;
	}
}

public class HashMap1 {
	Entry[] bucket;
	int size = 10;
	HashMap1() {
		this(10);
	}
	HashMap1(int size) {
		this.size = size;
		bucket = new Entry[size];
	}
	public boolean put(int key, int val) {
		int index = hash(key);
		if(bucket[index] == null) {
			bucket[index] = new Entry(key, val);
			return true;
		}
		else {
			int end = -1;
			while(bucket[index] != null && bucket[index].key != key && index != end) {
				if(end == -1) {
					end = index;
				}
				index = (index + 1) % size; 
			}
			if(bucket[index] == null) {
				bucket[index] = new Entry(key, val);
				return true;
			}
			else if(bucket[index].key == key) {
				bucket[index].value = val;
				return true;
			}
			else {
				return false;
			}
		}
	}
	
	public int get(int key) {
		int index = hash(key);
		if(bucket[index] == null) {
			return -1;
		}
		else {
			int end = -1;
			while(index != end && bucket[index] != null && bucket[index].key != key) {
				if(end == -1) {
					end = index;
				}
				index = (index + 1) % size;
			}
			if(bucket[index] == null) {
				return -1;
			}
			else if(bucket[index].key == key) {
				return bucket[index].value;
			}
			else {
				return -1;
			}
		}
	}
	
	public boolean remove(int key) {
		int index = hash(key);
		if(bucket[index] == null) {
			return false;
		}
		else {
			int end = -1;
			while(index != end && bucket[index] != null && bucket[index].key != key) {
				if(end == -1) {
					end = index;
				}
				index = (index + 1) % size;
			}
			if(bucket[index] == null) {
				return false;
			}
			else if(bucket[index].key == key) {
				bucket[index] = null;
				return true;
			}
			else {
				return false;
			}
		}
	}
	
	private int hash(int key) {
		return key % size;
	}
}
