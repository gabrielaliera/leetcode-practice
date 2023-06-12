/*
U: change all orginal 0 to have row/col = 0
Want: constant SPACE =  in-place

Match 
 hashmap to stor rol and col
 
 Create : copy matrix with T/F
 then iteratte and change to 0
 
plan:
  iterate through row
    iterate through col
     if matrix[row][col] == 0
            change to zeros
                    //while loop 
                    or helper
     else continue
     
 return matrix

[[0,1,2,0],
[3,4,5,2],
[1,3,1,5]]


[[0,0,0,0],
 [0,4,5,0],
 [0,3,1,0]]



*/


class Solution {
    public void setZeroes(int[][] matrix) {
        
        Boolean hasZeroCol = false;
        //print(matrix);
        //Create Flags
        for(int row = 0 ; row < matrix.length ; row++){
            
            if(matrix[row][0] == 0){
                hasZeroCol = true;
            }
            
            for(int col = 1; col < matrix[0].length; col++){
                if(matrix[row][col] == 0){
                    //Set flags
                    matrix[row][0] = 0;
                    matrix[0][col] = 0;
                    //matrix = toZero(row,col, matrix);
                }
            }
        }
      //  System.out.println("After flags");
     //   print(matrix);
     
        //Update elementes using flags
        for(int row = 1 ; row < matrix.length ; row++){
            for(int col = 1; col < matrix[0].length; col++){
                //if find a flag, set position to zero
                if(matrix[row][0] == 0 || matrix[0][col] == 0){
                    matrix[row][col] = 0;
                }
            }
        }
      //  System.out.println("2nd iteration");
      //  print(matrix);
        
        //Change first row if need
        if(matrix[0][0] == 0){
            for(int col = 0 ; col < matrix[0].length; col++){
                matrix[0][col] = 0;
            }
        }
     //   System.out.println("check first row");
   //     print(matrix);
        
        //Change first col if needs
        if(hasZeroCol){
            for(int row = 0; row < matrix.length; row ++){
                matrix[row][0] = 0;
            }
        }
      //  System.out.println("check first col");
     //   print(matrix);
       
        
    }
    
    //old idea
    public int[][] toZero(int row, int col, int[][]matrix){
        
        //Check for flags
        if(matrix[row][0] == 0 || matrix[0][col] == 0){
            return matrix;
        }
        //change rows
        for(int i = 0; i < matrix.length ; i++){
            matrix[i][col] = 0;
        }
        
        //change col
        for(int i = 0; i < matrix[0].length ; i++){
            matrix[row][i] = 0;
        }
        return matrix;
    }
    
    public void print(int[][]matrix){
          for(int row = 0 ; row < matrix.length ; row++){
            for(int col = 0; col < matrix[0].length; col++){
                System.out.print(matrix[row][col] +" ");
            }
            System.out.println();
        }
    }
}

/*

[[1,2,3,4],
 [5,0,7,8],
 [0,10,11,12],
[13,14,15,0]]

*/