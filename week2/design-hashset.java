class MyHashSet {

    /** Initialize your data structure here. */
    Node[] array;
    public MyHashSet() {
        array = new Node[10000];
        
    }
    
    public void add(int key) {
        int hashedKey = (key * 123) % 10000;
        if(array[hashedKey] == null){
            array[hashedKey] = new Node(key);
        }
        else{
            if(!contains(key)){
                Node current = array[hashedKey];
                while(current.next != null){
                    current = current.next;
                }
                current.next = new Node(key);
            }
        }
        
    }
    
    public void remove(int key) {
        if(contains(key)){
            
            int hashedKey = (key * 123) % 10000;
            if(array[hashedKey].key == key){
                array[hashedKey] = array[hashedKey].next;
            }
            else{
                Node current = array[hashedKey];
                Node prev = null;
                while(current.key != key){
                    prev = current;
                    current = current.next;
                }
                prev.next = prev.next.next;
            }
        }
        
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int hashedKey = (key * 123) % 10000;
        Node current = array[hashedKey];
        while(current != null){
            if(current.key == key) return true;
            current = current.next;
        }
        return false;
    }
}

class Node{
    int key;
    Node next;
    Node(int key){
        this.key = key;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */