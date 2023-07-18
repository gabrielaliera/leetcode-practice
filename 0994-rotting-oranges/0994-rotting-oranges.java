/*
dfs recursion

2 1 1    2 2 1    2 2 2    2 2 2
0 1 1 -> 0 1 1 -> 0 2 1 -> 0 2 2
1 0 1    1 0 1    1 0 1    1 0 2

1) iterate through each position
 if find a rotten == 2
   bfs

*/

class Solution {
    public int orangesRotting(int[][] grid) {
        
        
        Queue<int[]> queue = new LinkedList<>();
        int count_fresh = 0;
        //Find rotten and do bfs
        for(int r = 0 ; r < grid.length ; r++){
            for(int c = 0 ; c < grid[0].length; c++){
                if(grid[r][c] == 2) {
                    queue.offer(new int[]{r , c});
                }
                else if(grid[r][c] == 1) {
                    count_fresh++;
                }
            }
        }
        
        //Zero fresh to get rotten
        if(count_fresh == 0) {
            return 0;
        }
        
        int count = 0;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        //bfs starting from initially rotten oranges
        while(!queue.isEmpty()) {
            ++count;
            int size = queue.size();
            for(int i = 0 ; i < size ; i++) {
                int[] point = queue.poll();
                for(int dir[] : dirs) {
                    int x = point[0] + dir[0];
                    int y = point[1] + dir[1];
                    //if x or y is out of bound
                    //or the orange at (x , y) is already rotten
                    //or the cell at (x , y) is empty
                        //we do nothing
                    if( x < 0 || y < 0 || x >= grid.length || y >= grid[0].length ||                         grid[x][y] == 0 || grid[x][y] == 2) { 
                        continue;
                    }
                    
                    //mark the orange at (x , y) as rotten
                    grid[x][y] = 2;
                    
                    //put the new rotten orange at (x , y) in queue
                    queue.offer(new int[]{x , y});
                    
                    //decrease the count of fresh oranges by 1
                    count_fresh--;
                }
            }
        }
        return count_fresh == 0 ? count-1 : -1;
    }
}