package simple_hashmap;

class HashEntry {
	int key;
	int value;
	HashEntry next;
	HashEntry(int key, int val) {
		this.key = key;
		this.value = val;
		this.next = null;
	}
}

public class HashMap {
	private HashEntry[] bucket;
	private int size;
	HashMap(int len) {
		bucket = new HashEntry[len];
		size = len;
	}
	
	public void put(int key, int val) {
		int index = hash(key);
		if(bucket[index] == null) {
			bucket[index] = new HashEntry(key, val);
		}
		else {
			HashEntry exist = find(bucket[index], key);
			if(exist == null) {
				HashEntry head_new = new HashEntry(key, val);
				head_new.next = bucket[index];
				bucket[index] = head_new;
			}
			else {
				exist.value = val;
			}
		}
	}
	
	public HashEntry find(HashEntry head, int key) {
		if(head == null) {
			return null;
		}
		HashEntry cur = head;
		while(cur != null && cur.key != key) {
			cur = cur.next;
		}
		return cur;
	}
	
	public HashEntry find_pre(HashEntry head, int key) {
		if(head == null) {
			return null;
		}
		HashEntry cur = head;
		while(cur.next != null && cur.next.key != key) {
			cur = cur.next;
		}
		return cur;
	}
	
	public boolean remove(int key) {
		int index = hash(key);
		if(bucket[index] == null) {
			return false;
		}
		else {
			if(bucket[index].key == key) {
				bucket[index] = bucket[index].next;
			}
			else{
				HashEntry exist = find_pre(bucket[index], key);
				if(exist == null) {
					return false;
				}
				else {
					exist.next = exist.next.next;
				}
			}
		}
		return true;
	}
	
	public int get(int key) {
		int index = hash(key);
		if(bucket[index] == null) {
			return -1;
		}
		else {
			HashEntry exist = find(bucket[index], key);
			if(exist == null) {
				return -1;
			}
			else {
				return exist.value;
			}
		}
	}
	
	public int hash(int key) {
		return key % size;
	}
}
