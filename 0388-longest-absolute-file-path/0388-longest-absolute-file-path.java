
/*

inpur: stirng for complete file system

output lenght of longest absoliute path of file
or 0
Not the subdir - only FILES

0  dir
1 dir\sbudir1    stack dir subdir fileext

Use Stack
  
  
*/
class Solution {
    public int lengthLongestPath(String input) {
        
       
                
        Deque<Integer> stack = new ArrayDeque<>();
        
        stack.push(0); // "dummy" length
        int maxLen = 0;
        
        for(String s:input.split("\n")){
            int lev = s.lastIndexOf("\t")+1; // number of "\t"
            
            while( lev + 1 < stack.size()){
                stack.pop(); // find parent
            }
            
            int len = stack.peek() + s.length() - lev + 1; // remove "/t", add"/"
            stack.push(len);
            
            // check if it is file
            if (s.contains(".")) {
                maxLen = Math.max(maxLen, len-1);
            }
        }
        return maxLen;
    }
}