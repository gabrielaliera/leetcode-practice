class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        
        HashMap<Integer,Integer> count = new HashMap<>();
        ArrayList<Integer> res = new ArrayList<>();
        
        //Build first hashmap with number of occurances
        for(int i = 0; i < nums1.length; i++){
            int num = nums1[i];
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        
        //iterate through 2nd array
        for(int j=0; j<nums2.length; j++){
            int y = nums2[j];
            
            if (count.containsKey(y) && count.get(y) != 0){
                count.put(y,count.get(y)- 1);
                res.add(y);
               
            }
        }
       
        //Change array list to int[]
        int[] arr = new int[res.size()];
        int k=0;
        for(int num : res){
            arr[k++] = num;
        }
        return arr;
    }
}