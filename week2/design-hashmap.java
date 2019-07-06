class MyHashMap {
    
    Node[] array;
    
    /** Initialize your data structure here. */
    public MyHashMap() {
        array = new Node[10000];
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int hashedKey = (key * 23) % 10000;
        if(array[hashedKey] == null){
            array[hashedKey] = new Node(key, value);
        }
        else{
            //System.out.println("key: " + key +" value: " + value);
            if(get(key) == -1){
                Node curr = array[hashedKey];
                while(curr.next != null){
                    curr = curr.next;
                }
                curr.next = new Node(key, value);
            }
            else{
                Node curr = array[hashedKey];
                if(curr.key == key){
                    Node next = array[hashedKey].next;
                    curr.value = value;
                    curr.next = next;
                }
                else{
                    while(curr.next.key != key){
                        curr = curr.next;
                    }
                    Node next = curr.next.next;
                    curr.next = new Node(key, value);
                    curr.next.next = next;
                }

            }
        }
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int hashedKey = (key * 23) % 10000;
        Node current = array[hashedKey];
        while(current != null){
            if(current.key == key){
                return current.value;
            }
            current = current.next;
        }
        return -1;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int hashedKey = (key * 23) % 10000;
        if(array[hashedKey] == null) return ;
        if(array[hashedKey].key == key){
            array[hashedKey] = array[hashedKey].next;
        }
        else{
            Node current = array[hashedKey];
            while(current != null){
                if(current.next != null && current.next.key == key){
                    current.next = current.next.next;
                }
                current = current.next;
            }
        }
    }
}


class Node{
    int key;
    int value;
    Node next;
    
    Node(int k, int v){
        this.key = k;
        this.value = v;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */