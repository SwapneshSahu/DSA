package Mock_Practice;



public class Main{
	
	public static void main(String[] args) {
		MyHashMap map = new MyHashMap();
		map.put(1,10);
	}
}

class MyHashMap {
    private static class Entry {
        int key;
        int value;
        Entry next;

        Entry(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private static final int SIZE = 1000;
    private Entry[] table;

    /** Initialize your data structure here. */
    public MyHashMap() {
        table = new Entry[SIZE];
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index = getIndex(key);
        Entry entry = new Entry(key, value);

        if (table[index] == null) {
            table[index] = entry;
        } else {
            Entry prev = null;
            Entry current = table[index];
            while (current != null) {
                if (current.key == key) {
                    current.value = value;
                    return;
                }
                prev = current;
                current = current.next;
            }
            
            prev.next = entry;
        }
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = getIndex(key);
        Entry current = table[index];

        while (current != null) {
            if (current.key == key) {
                return current.value;
            }
            current = current.next;
        }

        return -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index = getIndex(key);
        Entry current = table[index];
        Entry prev = null;

        while (current != null) {
            if (current.key == key) {
                if (prev == null) {
                    table[index] = current.next;
                } else {
                    prev.next = current.next;
                }
                return;
            }
            prev = current;
            current = current.next;
        }
    }

    private int getIndex(int key) {
        return Integer.hashCode(key) % SIZE;
    }


}


