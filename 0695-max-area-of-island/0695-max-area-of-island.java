class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        
        for(int row = 0; row < grid.length ; row++){
            for(int col = 0; col < grid[0].length; col++){
                //if reach island, dfs to find size
                if(grid[row][col] == 1){
                    int islandSize = dfs(grid, row, col, new int[]{0});
                    max = Math.max(max, islandSize);
                }
            }
        }
        return max;
    }
    
    public int dfs(int[][] grid , int r, int c, int[] count){
        //Base case
        if( r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == 0){
            return count[0];
        }
        //change position to zero
        grid[r][c] = 0; 
        count[0]++;
        
        
        
        dfs(grid, r + 1 , c , count); //down
        dfs(grid, r - 1 , c , count); //up
        dfs(grid, r , c + 1,  count); //right
        dfs(grid, r , c - 1,  count);//left

        
        return count[0];
        
    }
}