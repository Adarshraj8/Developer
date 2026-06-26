class LRUCache {

    // Node of Doubly Linked List
    class Node {
        int key, value;
        Node prev, next;
        Node(int k, int v) {
            key = k;
            value = v;
        }
    }

    private int capacity;
    private Map<Integer, Node> map;  // key → Node
    private Node head, tail;         // dummy nodes

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();

        // Dummy head (least recent side) and tail (most recent side)
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    // Remove a node from DLL (anywhere)
    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // Insert node just before TAIL (= most recently used position)
    private void insertAtTail(Node node) {
        node.prev = tail.prev;
        node.next = tail;
        tail.prev.next = node;
        tail.prev = node;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;

        Node node = map.get(key);
        remove(node);        // apni purani jagah se hatao
        insertAtTail(node);  // most recent ban gaya
        return node.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            // Update karo aur most recent banao
            Node node = map.get(key);
            node.value = value;
            remove(node);
            insertAtTail(node);
        } else {
            // Capacity check
            if (map.size() == capacity) {
                // head.next = least recently used node
                Node lru = head.next;
                remove(lru);
                map.remove(lru.key);  // map se bhi hatao
            }
            // Naya node banao
            Node newNode = new Node(key, value);
            insertAtTail(newNode);
            map.put(key, newNode);
        }
    }
}