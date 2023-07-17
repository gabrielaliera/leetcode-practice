class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
        int oldColor = image[sr][sc];
        
        if(oldColor != color){
            dfs(image, sr, sc , oldColor, color);
        }
        
        return image;
    }
    
    public void dfs(int[][] image, int r, int c, int oldColor, int color){
        
        if(image[r][c] == oldColor){
            
            //Change position to correct color
            image[r][c] = color;
            
            //Check down
            if( r >= 1){
                dfs(image, r-1, c, oldColor, color); //down
            }
            
            //Check up
            if( r + 1 < image.length){
                
                dfs(image, r+1, c, oldColor,  color); //up
            }
            
            //check left
            if ( c >= 1 ){
                dfs(image, r , c-1, oldColor , color);
            }
            
            //check right
            if( c + 1 < image[0].length){
                dfs(image, r, c+1, oldColor, color);
            }
        }
        
        
    }
}