class Solution {
    
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    
    public List<List<Integer>> subsets(int[] nums) {
        
        List<Integer> cur = new ArrayList<Integer>();
        helper(0, nums, cur, res);
        return res;
    }
    
    public void helper(int i, int[]nums , List<Integer> cur, List<List<Integer>> res){
        
        if( i >= nums.length){
            res.add(new ArrayList<>(cur));
            return;
        }
        
        //Include in subset
        cur.add(nums[i]);
        helper(i + 1 , nums , cur, res);
        
        
        //Not include in subset
        cur.remove(cur.size() - 1);
        helper(i + 1 , nums , cur, res);
    
    }
}