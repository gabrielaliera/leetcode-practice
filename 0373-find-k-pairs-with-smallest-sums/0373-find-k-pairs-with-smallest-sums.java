/*

2 loop creating pairs
  
  add to list while list size < k

*/


class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        
       List<List<Integer>> pairs = new ArrayList<>();
    
    //Compare the sum
       PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> (a[0] + a[1]) - (b[0] + b[1]));
        
        //Add all nums1 with nums2[0]
        for (int i = 0; i < nums1.length && i < k; i++) {
            minHeap.offer(new int[] { nums1[i], nums2[0], 0 }); // { num1, num2, index of nums2 }
        }
        
        while (k > 0 && !minHeap.isEmpty()) {
            int[] current = minHeap.poll();
            int num1 = current[0];
            int num2 = current[1];
            int index2 = current[2];
            
            //Add current min from heap
            pairs.add(Arrays.asList(num1, num2));
            k--;
            
            if (index2 < nums2.length - 1) {
                minHeap.offer(new int[] { num1, nums2[index2 + 1], index2 + 1 });
            }
            
        }
        
        return pairs;
        
        
    }
    

    
}