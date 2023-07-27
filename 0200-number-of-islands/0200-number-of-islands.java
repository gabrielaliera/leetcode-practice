
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
        for(int i = 0; i< grid.length;  i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                    dfs(grid, i, j);
                    islands++;
                }
            }
        }
        return islands;
    }
    
    public void dfs(char[][] grid, int i , int j){
        //edges cases
        if( i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }
        
        //Sink position
        grid[i][j] = '0';
        
        //dfs up, down, left, right
        dfs(grid, i + 1, j); //down
        dfs(grid, i - 1, j); //up
        dfs(grid, i, j + 1); //right
        dfs(grid, i, j - 1); //left
    }
}