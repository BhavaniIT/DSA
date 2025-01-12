
import java.util.ArrayList;
public class Heap<T extends Comparable<T>> {
    private ArrayList<T> heap;

    public Heap() {
        heap = new ArrayList<>();
    }

    // Add an element to the heap
    public void add(T element) {
        heap.add(element);
        heapifyUp(heap.size() - 1); // Call the recursive heapifyUp
    }

    // Remove and return the root element
    public T remove() {
        if (heap.isEmpty()) return null;

        T root = heap.get(0);
        T last = heap.remove(heap.size() - 1);
        if (!heap.isEmpty()) {
            heap.set(0, last);
            heapifyDown(0); // Call the recursive heapifyDown
        }
        return root;
    }

    // Recursively adjust the heap upwards
    private void heapifyUp(int index) {
        if (index <= 0) return; // Base case: Reached the root

        int parentIndex = (index - 1) / 2;
        if (heap.get(index).compareTo(heap.get(parentIndex)) < 0) {
            swap(index, parentIndex);
            heapifyUp(parentIndex); // Recursively adjust the parent
        }
    }

    // Recursively adjust the heap downwards
    private void heapifyDown(int index) {
        int leftChild = 2 * index + 1;
        int rightChild = 2 * index + 2;
        int smallest = index;

        // Check if the left child is smaller
        if (leftChild < heap.size() && heap.get(leftChild).compareTo(heap.get(smallest)) < 0) {
            smallest = leftChild;
        }

        // Check if the right child is smaller
        if (rightChild < heap.size() && heap.get(rightChild).compareTo(heap.get(smallest)) < 0) {
            smallest = rightChild;
        }

        // If the smallest is not the current index, swap and recurse
        if (smallest != index) {
            swap(index, smallest);
            heapifyDown(smallest); // Recursively adjust the child
        }
    }

    // Swap two elements in the heap
    private void swap(int i, int j) {
        T temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
}
