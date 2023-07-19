
//main
//track of islands


//helper
//recursive
//up
//down
//right
//left


//dfs


class Solution {
    public int numIslands(char[][] grid) {
        int islands = 0;
        
        //locate first island
        for(int r = 0; r < grid.length; r++){
            for(int c = 0; c < grid[0].length; c++){
                                
                //dfs if find 1
                if(grid[r][c] == '1'){
                    islands++;
                    dfs(grid,r,c);
                }
            }
        }
        return islands;
        
    }
    
    
    public void dfs(char[][]grid, int r, int c){
        
        
        if( r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c]== '0'){
            return;
        }
            grid[r][c] = '0';
            dfs(grid,r-1,c);
            dfs(grid,r+1,c);
            dfs(grid,r,c-1);
            dfs(grid,r,c+1);
        
     
        
    }
}