public class LRUCacheTest {

    public static void main(String[] args) {
        LRUCache<Integer, String> cache = new LRUCache<>(2);

        cache.put(1, "A");
        cache.put(2, "B");

        System.out.println(cache.get(1)); // A

        cache.put(3, "C"); // Evicts key 2

        System.out.println(cache.get(2)); // null
        System.out.println(cache.get(3)); // C
        System.out.println(cache.get(1)); // A
    }
}
