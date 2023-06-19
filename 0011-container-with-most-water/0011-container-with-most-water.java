/*
Input:
height of line can be 0

Output: MAx amount of water
2 highest line at index 1 , 8
water = height  * lenghts
    = maxHeight(2nd) * (index2- index1)
    
    
M:
  brute - 2 for loops - O(n^2)
  2 pointer to find max legnth
  sliding window - decreasing in size
  heap - height, index

Plan: 

idea: find tallest, then calculate all area O(2n) but maybe wont alway find maxArea
idea: add all to heap, then area distance for all others 
idea: two pointer - start with largest distance and move pointers inward
*/
class Solution {
    //Brute
  /*  public int maxAreaBrute(int[] height) {
        
        int maxWater = 0;
        for(int i = 0; i < height.length ; i++){
            for(int j = i + 1; j < height.length; j++){
                
                int currentHeight = Math.min(height[i],height[j]);
                int area = currentHeight * (j - i);
                maxWater = Math.max(maxWater, area);
            }
        }
        return maxWater;
    }
    */
    
    //Optimized with 2 pointer
    public int maxArea(int[] height) {
        
        int maxWater = 0;
        int left = 0;
        int right = height.length - 1;
        
        while(left < right){
            //calculate area
            int width = right - left;
            int minHeight = Math.min(height[left], height[right]);
            //calculate maxWater
            maxWater = Math.max(maxWater, width * minHeight);
            
            //Move pointers
            if(height[left] > height[right]){
                right--;
            } else if( height[left] < height[right] ){
                left++;
            } else {
                left++;
                right--;
            }
        }
        return maxWater;
    }
}
