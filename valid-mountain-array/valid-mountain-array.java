/*


need something to hold max
two pointers: curr num vs next num
 iterate through num i =1
 
 if max < arr[i]
    isUphill = false
 
 if arr[i-1] < arr[i] and isUphill(true)
    reset max to arr[i]
    continue- good
//downhill
 else if arr[i-1] > arr[i] and isUphill(false)
   contine
 else 
    return false
boolean to show downhill or downhill helper method

return true
*/


class Solution {
    public boolean validMountainArray(int[] arr) {
        boolean isUphill = true;
        int max = arr[0];
        
        //base case
        if (arr.length <= 1) return false;
        
        for(int i = 1 ; i < arr.length; i++){
            
            //Check if at peak
            if (max > arr[i]){ 
                isUphill = false;
            }
            //System.out.println("i "+i+" max: "+max);
            //check for increasing
            if(arr[i-1] < arr[i] && isUphill){
               // System.out.println("i "+i+" max: "+max);
                max = arr[i];
            //check for descreasing
            } else if (arr[i-1] > arr[i] && !isUphill && i != 1){
                continue;
            } else{
                return false;
            }
        } 
        
        //never went downhill
        if( isUphill) return false;
        
        return true;
    }
}