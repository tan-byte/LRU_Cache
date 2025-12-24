import java.util.HashMap;
import java.util.Map;

/**
 * Generic LRU Cache implementation using
 * HashMap + Doubly Linked List.
 *
 * Time Complexity:
 * get()  -> O(1)
 * put()  -> O(1)
 */
public class LRUCache<K, V> {

    // ===== Doubly Linked List Node =====
    private class Node {
        K key;
        V value;
        Node prev;
        Node next;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;
    private final Map<K, Node> cache;

    // Dummy head & tail
    private final Node head;
    private final Node tail;

    // ===== Constructor =====
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();

        head = new Node(null, null);
        tail = new Node(null, null);

        head.next = tail;
        tail.prev = head;
    }

    // ===== Get =====
    public V get(K key) {
        Node node = cache.get(key);
        if (node == null) {
            return null; // or -1 for integer caches
        }

        moveToFront(node);
        return node.value;
    }

    // ===== Put =====
    public void put(K key, V value) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value;
            moveToFront(node);
            return;
        }

        if (cache.size() == capacity) {
            Node lru = removeLRU();
            cache.remove(lru.key);
        }

        Node newNode = new Node(key, value);
        addToFront(newNode);
        cache.put(key, newNode);
    }

    // ===== Helper Methods =====

    private void addToFront(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToFront(Node node) {
        removeNode(node);
        addToFront(node);
    }

    private Node removeLRU() {
        Node lru = tail.prev;
        removeNode(lru);
        return lru;
    }
}
