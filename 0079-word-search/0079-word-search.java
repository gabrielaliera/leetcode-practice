/*


DFS
  iterate through each letter
    if a == first char of string
       wordExist = do dfs boolean
       if wordExisit === true
         break
  
  return wordExist

DFS ( board, r, c, word , index )
 
 if( r <0 etc  || board[r][c] != word[index])
   return false
   
  index++;
  wordExist = dfs() up || dwon
   

  return wordExist

*/

class Solution {
     public static boolean exist(char[][] grid, String word) {
         
        
        for(int r = 0; r < grid.length; r++){
            for(int c = 0; c < grid[0].length; c++){
                if(dfs(grid, r, c, word)) {
                    return true;
                }
            }
        }
        return false;
    }

     public static boolean dfs(char[][] board, int r, int c, String word) {
        
        //Base case, whole word has been found
        if (word.length() == 0) {
            return true;
        }
        //Out of bounds or not correct character
        if( r < 0 || r >= board.length || c < 0 || c >= board[0].length || 
            board[r][c] != word.charAt(0)){
            return false;
        }

        boolean result = false;
        board[r][c] = '*';
        // Explore the four neighboring directions
        // that is right, left, up, down by adding
        // (0, 1), (1, 0), (0, -1), (-1, 0) indices respectively
        int[][] offsets = {
            {0, 1}, {1, 0}, {0, -1}, {-1, 0}
        };
        for (int[] offset: offsets) {
            int rowOffset = offset[0];
            int colOffset = offset[1];
            result = dfs(board , r + rowOffset, c + colOffset, word.substring(1));

            // Break instead of implementing all steps and wasting our time
            if (result) {
                break;
            }
        }
            //Reset the char
        board[r][c] = word.charAt(0);   

        return result; 
            
    }
        
}