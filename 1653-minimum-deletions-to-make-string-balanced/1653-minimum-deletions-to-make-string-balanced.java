class Solution {
    public int minimumDeletions(String s) {
//         int deletions = 0;
//         int i = 0;
//         boolean firstA = false, firstB = false;
//         boolean allB = true, allA = true;
        
//         while(firstA == false && i < s.length()){
//             //delete all B before first A ---> BBAB
//             if(s.charAt(i) == 'b' ){
//                 deletions++;
//                 allA = false;
//             } else{
//                 firstA = true;
//                 allB = false;
//             }
//             i++;
//         }
        
//         //check if all B
//         if(allB){return 0;}
        
//         //continue iterating through A until reach first B
//         while(firstB == false && i < s.length()){
//             if(s.charAt(i) == 'b'){
//                 firstB = true;
//                 allA = false;
//             }
//             i++;
//         }
        
//         //check if all B
//         if(allA){return 0;}
        
//         //delete all a
//         while(i < s.length()){
//             if(s.charAt(i) == 'a'){
//                 deletions++;
//             }
//             i++;
//         }
        
//         return deletions;
        
        //preprocessing number of a prefix
        int size = s.length();
        int[] A = new int[size];
    
        //check if last char is a
        A[size-1] = s.charAt(size -1 ) == 'a' ? 1 : 0;
        
        //iterate from right to left and insert number of A
        for(int i = size -2; i >=0; i--){
            A[i] = A[i+1] + (s.charAt(i) == 'a' ? 1 : 0);
        }
        
        
        //iterate from left ot right to check b
        int result = Integer.MAX_VALUE;
        int bCount = 0;
        for(int i = 0; i < size; i++){
            if(s.charAt(i) == 'b'){
                result = Math.min(result, bCount + A[i]);
                bCount++;
            }
        }
        //check the case for all b
        result = Math.min(result, bCount);
        
        //if result is max_value means all a
        return result == Integer.MAX_VALUE ? 0 : result;
        
        
        
        
        
    }
}