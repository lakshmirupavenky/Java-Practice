import java.util.*;
public class windowslide {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        int[] result = new int[n - k + 1];                
        for (int i = 0; i < k; i++) {
            queue.offer(nums[i]);
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        result[0] = queue.peek();                
        for (int i = k; i < n; i++) {
            int out = nums[i - k];
            map.put(out, map.get(out) - 1); 
            int in = nums[i];
            queue.offer(in);
            map.put(in, map.getOrDefault(in, 0) + 1);                        
            while (map.get(queue.peek()) == 0) {
                queue.poll();
            }
            result[i - k + 1] = queue.peek();
        }
        return result;
    }
    public static void main(String[] args) {
        windowslide solution = new windowslide(); 
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] result = solution.maxSlidingWindow(nums, k);
        System.out.println("Max Sliding Window:");
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
