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

      //  System.out.println("i "+i+" j "+j);
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

        //  System.out.println("i "+i+" j "+j);
        //print
//         for(int num : ans){
//             System.out.print(num+" ");
//         }
        
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
    
    
    //solution O(log( m+n))
    public double findMedianBinarySearch(int[] nums1 , int[]nums2){
        int m = nums1.length;
        int n = nums2.length;
        
        //flip if nums2 is large
        if( m > n ){
            return findMedianBinarySearch(nums2 , nums1);
        }
        
       //do bianry search on smaller array 
        int total = m + n;
        int half = (total +1) / 2;
        double result = 0.0;
        
        //partition bounaries
        int left = 0;
        int right = m;
        
        while(left <= right){ //??? maybe
            
            int mid = (left + right) / 2;
            int end = half - mid;
            System.out.println(m);
            
            int left1 = (mid > 0 )? nums1[mid - 1] : Integer.MIN_VALUE;
            int right1 = (mid < m )? nums1[mid] : Integer.MAX_VALUE;
            
            int left2 = (end > 0)? nums2[end - 1] : Integer.MIN_VALUE;
            int right2 = (end < n)? nums2[end] : Integer.MAX_VALUE;
            
            int count = 1;
            System.out.println(left1 +" "+right1 +" "+ left2 +" " + right2 +" "+ total);
            //partition correct
            if(left1 <= right2 && left2 <= right1){
                
                //Even total size
                if(total % 2 == 0){
                    
                    result = (Math.max(left1, left2) + Math.min(right1, right2) )/2.0;
                    
                 //odd total size   
                }else{
                    result = Math.max(left1, left2);
                }                 
                break;
            //partition incorrect - update pointers    
            } else if (left1 > right2){
                 right  = mid - 1;
            } else {
                 left = mid + 1;
            }   
            
        }
        return result;
        
        
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        //int[] res = merge(nums1, nums2);
        //return median(res);
        return findMedianBinarySearch(nums1, nums2);
    }
}