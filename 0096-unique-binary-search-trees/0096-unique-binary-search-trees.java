/*



Outpout: Num of BST
   left children is smaller 
   right child is larger
   
   n=0 0
   n=1 1
   n=2 1
   n=3 5
   n=4  = 16 Caatataln numbwers
   
   https://www.geeksforgeeks.org/program-nth-catalan-number/
   c = 
*/


class Solution {
  
    //use map as the DP cache, store the number of unique BST that the key number can generate
    private HashMap<Integer, Integer> map = new HashMap<>();
    
    public int numTrees(int n) {
        if (map.containsKey(n)) {
            return map.get(n);
        }
        if (n == 0) {
            map.put(0, 1);
            return 1;
        }
        int res = 0;
        //loop through n, because of BST, so the left side is numTrees(i - 1), and right side is numTrees(n - i)
        for (int i = 1; i <= n; i++) {
            res += numTrees(i - 1) * numTrees(n - i);
        }
        //when we get the res, put it in the map
        map.put(n, res);
        return res;
    }
}