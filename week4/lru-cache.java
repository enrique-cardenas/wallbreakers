class LRUCache {

    Map<Integer, DoublyLinkedListNode> map = new HashMap<>();
    DoublyLinkedListNode head = null;
    DoublyLinkedListNode tail = null;
    int size = 0;
    int capacity;
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        
        DoublyLinkedListNode node = map.get(key);
        moveToFront(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        
        DoublyLinkedListNode node = new DoublyLinkedListNode(key, value);
        if(!map.containsKey(key)){
            if(size == capacity){
                removeLRU();
            }
            map.put(key, node);
            addToFront(node);
            size++;
        }
        else{
            DoublyLinkedListNode nodeToMove = map.get(key);
            moveToFront(nodeToMove);
            nodeToMove.val = value;
            map.put(key, nodeToMove);   
        }
    }
    
    public void removeLRU(){
        
        if(capacity > 1){
            DoublyLinkedListNode next = tail.next;
            next.prev = null;
            tail.next = null;
            map.remove(tail.key);
            tail = next;
        }
        else{
            map.remove(tail.key);
            tail = null;
            head = null;
        }
        size--;
    }
    
    public void addToFront(DoublyLinkedListNode node){
        if(size == 0){
            head = node;
            tail = node;
        }
        else{
            head.next = node;
            node.prev = head;
            head = node;
        }
    }
    
    public void moveToFront(DoublyLinkedListNode node){
        if(node == head){
            return ;
        }
        if(node == tail){
            DoublyLinkedListNode temp = tail.next;
            tail.next = null;
            tail.prev = head;
            head.next = tail;
            tail = temp;
            head = node;
        }
        else{
            DoublyLinkedListNode prev = node.prev;
            DoublyLinkedListNode next = node.next;
            
            prev.next = next;
            next.prev = prev;
            
            node.next = null;
            node.prev = head;
            head.next = node;
            head = node;
        }
    }
    
    class DoublyLinkedListNode{
        DoublyLinkedListNode next, prev;
        int key;
        int val;
        public DoublyLinkedListNode(int key, int val){
            this.key = key;
            this.val = val;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */