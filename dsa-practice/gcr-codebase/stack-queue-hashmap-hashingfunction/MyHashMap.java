import java.util.*;

class MyHashMap<K, V> {

    private static class Node<K, V> {
        K key;
        V value;

        Node(K k, V v) {
            key = k;
            value = v;
        }
    }

    private LinkedList<Node<K, V>>[] buckets;
    private int size;
    private int capacity;
    private final double LOAD_FACTOR = 0.75;

    @SuppressWarnings("unchecked")
    public MyHashMap() {
        capacity = 16;
        buckets = new LinkedList[capacity];
        size = 0;
    }

    private int hash(K key) {
        return Math.abs(key.hashCode()) % capacity;
    }

    // Insert or Update
    public void put(K key, V value) {

        int index = hash(key);

        if (buckets[index] == null) {
            buckets[index] = new LinkedList<>();
        }

        for (Node<K, V> node : buckets[index]) {
            if (node.key.equals(key)) {
                node.value = value;
                return;
            }
        }

        buckets[index].add(new Node<>(key, value));
        size++;

        if ((double) size / capacity >= LOAD_FACTOR) {
            resize();
        }
    }

    // Retrieve
    public V get(K key) {

        int index = hash(key);

        if (buckets[index] == null) return null;

        for (Node<K, V> node : buckets[index]) {
            if (node.key.equals(key)) {
                return node.value;
            }
        }

        return null;
    }

    // Delete
    public boolean remove(K key) {

        int index = hash(key);

        if (buckets[index] == null) return false;

        Iterator<Node<K, V>> it = buckets[index].iterator();

        while (it.hasNext()) {
            Node<K, V> node = it.next();
            if (node.key.equals(key)) {
                it.remove();
                size--;
                return true;
            }
        }

        return false;
    }

    public int size() {
        return size;
    }

    @SuppressWarnings("unchecked")
    private void resize() {

        LinkedList<Node<K, V>>[] oldBuckets = buckets;
        capacity *= 2;
        buckets = new LinkedList[capacity];
        size = 0;

        for (LinkedList<Node<K, V>> bucket : oldBuckets) {
            if (bucket != null) {
                for (Node<K, V> node : bucket) {
                    put(node.key, node.value);
                }
            }
        }
    }
}
