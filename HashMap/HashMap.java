import java.util.LinkedList;

public class HashMap<K, V> {
    class Node {
        K key;
        V value;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private LinkedList<Node>[] bucketArray;
    private int size;
    private int capacity;
    private final double loadFactor = 0.75;

    public HashMap() {
        this.capacity = 16;
        this.size = 0;
        this.bucketArray = new LinkedList[capacity];
    }

    private int getBucketIndex(K key) {
        int hashCode = key.hashCode();
        return Math.abs(hashCode) % capacity;
    }

    public void put(K key, V value) {
        int bucketIndex = getBucketIndex(key);

        if (bucketArray[bucketIndex] == null)
            bucketArray[bucketIndex] = new LinkedList<>();

        for (Node node : bucketArray[bucketIndex]) {
            if (node.key.equals(key)) {
                node.value = value;
                return;
            }
        }

        bucketArray[bucketIndex].add(new Node(key, value));
        size++;

        if ((double) size % capacity > loadFactor) {
            resize();
        }
    }

    private void resize() {
        int newCapacity = capacity * 2;
        LinkedList<Node>[] newBucketArray = new LinkedList[newCapacity];
        for (LinkedList<Node> bucket : bucketArray) {
            if (bucket != null) {
                for (Node node : bucket) {
                    int newBucketIndex = Math.abs(node.key.hashCode()) % newCapacity;
                    if (newBucketArray[newBucketIndex] == null)
                        newBucketArray[newBucketIndex] = new LinkedList<>();

                    newBucketArray[newBucketIndex].add(node);

                }
            }
        }
        bucketArray = newBucketArray;
        capacity = newCapacity;
    }

    public int size() {
        return size;
    }

    public V get(K key) {
        int bucketIndex = getBucketIndex(key);
        for (Node node : bucketArray[bucketIndex]) {
            if (node.key.equals(key))
                return node.value;
        }
        return null;
    }

    public void remove(K key) {
        int bucketIndex = getBucketIndex(key);
        LinkedList<Node> bucket = bucketArray[bucketIndex];

        if (bucket == null)
            return;
        for (Node node : bucket) {
            if (node.key.equals(key)) {
                bucket.remove(node);
                size--;
                return;
            }
        }
    }

    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();

        // Add key-value pairs
        map.put("One", 1);
        map.put("Two", 2);
        map.put("Three", 3);

        // Print values
        System.out.println("Value for key 'One': " + map.get("One")); // Output: 1
        System.out.println("Value for key 'Two': " + map.get("Two")); // Output: 2
        System.out.println("Value for key 'Three': " + map.get("Three")); // Output: 3

        // Print size
        System.out.println("Size of HashMap: " + map.size()); // Output: 3

        // Remove a key
        map.remove("Two");
        // Check size after removal
        System.out.println("Size after removal: " + map.size()); // Output: 2

        HashMap<Integer, String> map2 = new HashMap<>();

        map2.put(1, "One");
        map2.put(2, "Two");
        map2.put(3, "Three");
        System.out.println("Size : " + map2.size()); // Output: 2

        map2.remove(2);
        System.out.println("Size after removal: " + map2.size()); // Output: 2

    }

}
