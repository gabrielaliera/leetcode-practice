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
    public int numTrees(int n) {
        
        int res = 0;
 
        // Base case
        if (n <= 1) {
            return 1;
        }
        for (int i = 0; i < n; i++) {
            res += numTrees(i) * numTrees(n - i - 1);
        }
        return res;
        
    }
}