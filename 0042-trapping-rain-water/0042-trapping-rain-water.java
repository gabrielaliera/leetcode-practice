/*


U: 
input - h can be 0 not -1


P:
two-pointer
 find total area - heights and inclusive on first pointer
 
 min(maxLeft, maxRight)  - height[i]

*/
class Solution {
    public int trap(int[] height) {
        
        int water = 0;
        
        int left = 0;
        int right = height.length - 1;
        int maxLeft = 0;
        int maxRight = 0;
        
        if(height.length <=1) {
            return water;
        }
        
        while(left <= right){
            if(maxLeft <= maxRight){
                int container = Math.max(maxLeft - height[left] , 0);
                water+= container;
                
                //update leftmax
                maxLeft = Math.max(maxLeft, height[left]);
                left++;
            } else {
                int container = Math.max(maxRight - height[right] , 0);
                water+= container;
                
                //update max and pointer
                maxRight = Math.max(maxRight, height[right]);
                right--;
            }
        }
        
        return water;
        
    }
}