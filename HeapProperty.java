import java.util.*;
public class HeapProperty {
    public static boolean isMinHeap(int[] heap) {
        int m = heap.length;
        for (int i = 0; i <= (m - 2) / 2; i++) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            if (left < m && heap[i] > heap[left]) {
                return false;
            }
            if (right < m && heap[i] > heap[right]) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int[] validHeap = {5, 10, 15, 20, 25};     
        int[] invalidHeap = {10, 5, 20, 15};       
        System.out.println("Is validHeap a Min Heap? " + isMinHeap(validHeap));
        System.out.println("Is invalidHeap a Min Heap? " + isMinHeap(invalidHeap));
    }
}
