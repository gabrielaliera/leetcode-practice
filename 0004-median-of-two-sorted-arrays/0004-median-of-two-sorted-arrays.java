class Solution {
    public static int[] merge(int[] nums1 , int[] nums2){
        
        int[] ans = new int[nums1.length + nums2.length];

        int i = 0;
        int j = 0;
        int index = 0;

        //combine until one is 0
        while(i  < nums1.length  && j < nums2.length){

          //A[Aptr] is smaller
          if(nums1[i] <= nums2[j]){    
             ans[index] = nums1[i];
             i++;
          } else {
             ans[index] = nums2[j];
             j++;
          }
          index++;

        }

        System.out.println("i "+i+" j "+j);
        //add the the empty array
        
        //i reach the end of array so add rest of nums2 
        if(i == nums1.length){
          //add b
          while(j < nums2.length){
            ans[index++] = nums2[j++];
          }
        }
        
        //j reach end of array so add rest of nums1
        if(j == nums2.length) {
          //add a
           while(i < nums1.length){
            ans[index++] = nums1[i++];
          }
        }

          System.out.println("i "+i+" j "+j);
        //print
        for(int num : ans){
            System.out.print(num+" ");
        }
        
        return ans;
    
  }
    
    public static double median(int[] merged){
        int size = merged.length;

        if(size % 2 == 0){
          //even
          int index = size/ 2;
          return (double) (merged[index]  + merged[index -1] )/2;

        } else {
          //odd size
          return (double) merged[size/2];

        }
      }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        int[] res = merge(nums1, nums2);
        return median(res);
    }
}