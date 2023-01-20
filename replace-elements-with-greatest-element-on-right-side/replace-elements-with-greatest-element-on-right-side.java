/*

brute force - nested for loops


*/

class Solution {
    public int[] replaceElements(int[] arr) {
                
//        Brute force
        //for(int i = 0; i < arr.length ; i++){
//            int max = Integer.MIN_VALUE;
           
//           for( int j = i + 1 ; j < arr.length ; j++){
//                max = Math.max(max, arr[j]);
//            }    
//            arr[i] = max;
//         }
        
        
//         arr[arr.length - 1] = -1;
                
        
//         return arr;
        
        //Optimized - one pass
        int max = - 1;
        for(int i = arr.length - 1 ; i >= 0 ; i--){
            int num = arr[i];
            arr[i] = max;
            max = Math.max(num, max);
        }
        
        return arr;
    }
}