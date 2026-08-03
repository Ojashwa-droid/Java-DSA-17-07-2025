class LRUCache {
    private Map<Integer, Node> cache; // {key, Node} & Node = {key, value}
    private final int capacity;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.cache = new HashMap<>();
        this.capacity = capacity;

        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);

        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (!cache.containsKey(key)) return -1;

        Node node = cache.get(key);
        deleteNode(node);
        insertAtFront(node);

        return node.value; 
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value;

            deleteNode(node);
            insertAtFront(node);
            return;
        }

        if (cache.size() == capacity) {
            // the last node, just before the dummy tail node is the least recently used node
            // so we simply delete that 

            Node nodeToBeDeleted = tail.prev;
            deleteNode(nodeToBeDeleted);
            cache.remove(nodeToBeDeleted.key);

            Node node = new Node(key, value);
            insertAtFront(node);
            cache.put(key, node);
        } else {
            Node node = new Node(key, value);
            insertAtFront(node);
            cache.put(key, node);
        }
    }

    private void deleteNode(Node node) {
        Node prevNode = node.prev;
        Node nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    private void insertAtFront(Node node) {
        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;
    }

    private class Node {
        int key, value;
        Node next, prev;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */