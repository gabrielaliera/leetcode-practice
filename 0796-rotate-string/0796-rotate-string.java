class Solution {
//     public boolean rotateString(String s1, String s2) {
//         //Edge case
//     if( s1.length() != s2.length()){return false;}

//     int s1Ptr = 0, s2Ptr = 0;

//     //find first letter of s1 in s2
//     for(int i = 0; i < s2.length(); i++){
//       if(s1.charAt(0) == s2.charAt(i)){
//           s2Ptr = i;
//           break;
//       }
//     }

//         System.out.println(s2Ptr);
//     while(s1Ptr < s1.length()){

//       //rotation
//       if(s2Ptr == s2.length()){
//         s2Ptr = 0;
//       }
//       if(s1.charAt(s1Ptr) != s2.charAt(s2Ptr)){
//         return false;
//       }
//         System.out.println(s1.charAt(s1Ptr) +" "+ s2.charAt(s2Ptr));
//       s1Ptr++; s2Ptr++;
//     }

//     return true;}
        
        
        
//         ///
    
    
    
//      public boolean rotateString(String s1, String s2) {
//         //Edge case
//         if( s1.length() != s2.length()){return false;}

//         int s1Ptr = s1.length()- 1, s2Ptr = 0;
   
//          //find prefix s1 in s2
//         for(int i = 0; i < s2.length(); i++){
//           if(s1.charAt(s1Ptr) == s2.charAt(i)){
//               s2Ptr = i;
//               break;
//           }
//         }
         
//         String end = s1.substring(s1Ptr - s2Ptr);
//         String start = s1.substring(0,s1Ptr-s2Ptr); 
//          String reverseS1 = end + start;
//              System.out.println(reverseS1);
//          //System.out.println(suffix);
         
//             return reverseS1.equals(s2);
//      }

    public boolean rotateString(String s1, String s2) {
        //Edge case
        if( s1.length() == s2.length() && s1.length() > 0){
            
            String combine = s1 + s1;
            return combine.contains(s2);
        }

       return false;    
        
     }

}