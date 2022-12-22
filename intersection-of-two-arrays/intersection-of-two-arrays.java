class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        HashMap<Integer, Integer> intersectSet = new HashMap<>();
       
        //Add nums1 to set
        for(int num: nums1){
            set.add(num);
        }
        //Iterate through nums
        for(int num: nums2){
            if(set.contains(num) && !intersectSet.containsKey(num)){
                intersectSet.put(num,0);
            }
        }
       
        //Convert to array
        int i=0;
        int[] array = new int [intersectSet.size()];
        for(Map.Entry<Integer,Integer> pair: intersectSet.entrySet()){
            array[i++] = pair.getKey();
        }
        
        
        return array;
    }
}