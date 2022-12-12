class Solution {
    public void reverseString(char[] s) {
        int leftPtr = 0;
        int rightPtr = s.length-1;

        while(leftPtr<rightPtr){
            char temp = s[leftPtr];
            s[leftPtr] = s[rightPtr];
            s[rightPtr] = temp;
            leftPtr++;
            rightPtr--;
        }
     
    }
}