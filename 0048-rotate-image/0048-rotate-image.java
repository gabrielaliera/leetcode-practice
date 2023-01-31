class Solution {
    public void rotate(int[][] matrix) {
         
   int L = 0;
   int R = matrix.length - 1;
  

    while(L <= R){
      
      
      for(int i = 0 ; i < R - L; i++){
       
        int top = L;
        int bottom  = R;
        
        //save top value
        int temp = matrix[top][L + i];

        //Move bottom left to top left
        matrix[top][L + i ] = matrix[bottom - i][L];
      
        //Move bottom right to bottom left
        matrix[bottom - i][L] = matrix[bottom][R - i];
      
        //move top right to bottom right
         matrix[bottom][R - i] = matrix[top + i][R];
      
        //Move top right to save temp( top left)
         matrix[top+ i][R] = temp;       
      }
      L++;
      R--;
    }
   
        
    }
}