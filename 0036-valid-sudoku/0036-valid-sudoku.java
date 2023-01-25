/*


3 helpers functions
  check row
  check columns 
  
  check boxes


*/

import java.util.HashSet;
class Solution {
    
    public boolean checkRow(char[][]board){
        for(int row = 0; row < board.length ; row++){
            HashSet<Character> nums = new HashSet<>();
            
            for(int col = 0 ; col < board[0].length ; col++){
                
                if( board[row][col] == '.'){
                    continue;
                }
                
                if(nums.contains(board[row][col])){
                    return false;
                } 
                nums.add(board[row][col]);
                
            }
        }
        return true;
    }
    
    
    public boolean checkCol(char [][] board){
        
        for(int col = 0; col < board.length ; col++){
            HashSet<Character> nums = new HashSet<>();
            for(int row = 0 ; row < board[0].length ; row++){
               
                if( board[row][col] == '.'){
                    continue;
                }
                
               if(nums.contains(board[row][col])){
                    return false;
                } 
                nums.add(board[row][col]);
                
            }
        }
        return true;
    }
    
    
    public boolean checkBox(char[][] board){
        
        HashSet<Character>[] boxes = new HashSet[board.length];
        
        for(int i= 0; i < board.length ; i++){
            boxes[i] = new HashSet<Character>();
        }
        
        for(int row = 0 ; row < board.length; row++){
            for(int col = 0 ; col < board.length ; col++){
                
               
                if( board[row][col] == '.'){
                    continue;
                }
                
                int index = (row/3) * 3 + col/3;
              //  System.out.println(index + " "+row+" "+col);
                
                if(boxes[index].contains(board[row][col])){
                        return false;
                } 
                boxes[index].add(board[row][col]);
            }
          
        }
        return true;
    }
    public boolean isValidSudoku(char[][] board) {
        
        System.out.println(checkCol(board));
        System.out.println(checkRow(board));
        System.out.println(checkBox(board));
        
        return checkCol(board) && checkRow(board) &&checkBox(board);
    }
}