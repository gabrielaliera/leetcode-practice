class Solution {
        
        /*
        
        move right
        move down 
        move left
        move up
        
        
        */
    
        public List<Integer> spiralOrder(int[][] matrix) {
            
            List<Integer> res = new ArrayList<>();
            
            int m = matrix.length;
            int n = matrix[0].length;
            
            int left = 0;
            int right = matrix[0].length - 1;
            
            int top = 0;
            int bottom = matrix.length -1;
            
            while( left <= right && top <= bottom ){
                
                //move across matrix[top][i]
                for(int i = left ; i <= right ; i++){
                    res.add(matrix[top][i]);
                }
                top++;
                
                //move down matrix[j][right]
                for(int j = top; j <= bottom; j++){
                    res.add(matrix[j][right]);
                }
                right--;
                
                //move left matrix[bottom][k]
                if( top <= bottom){
                    for(int k = right; k >= left; k-- ){
                        res.add(matrix[bottom][k]);
                    }
                      
                }
                 bottom --;
                
               if(left <= right){
                    //move up matirx[p][left]
                for(int p = bottom; p >= top ; p--){
                    res.add(matrix[p][left]);
                }
               
               }
                left++;
               
            }
            return res;
        }
    
    
    
    
    
    
    
    
    
    public List<Integer> spiralOrder2(int[][] matrix) {
         // Replace this placeholder return statement with your code
        List<Integer> result = new ArrayList<>();

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }
       
        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1 ;
        
        boolean isHop = true;
        int value = 0;

        while (left <= right && top <= bottom){
            
            System.out.println("Start left "+ left +" right "+ right+ " top "+ top+ " botton "+ bottom);
            //get every i in top row
            for(int i = left; i <= right; i++){
                result.add(matrix[top][i]);
                System.out.println(matrix[top][i]);
                if(isHop){
                    value = matrix[top][i];
                }
                isHop = !isHop;
            }
            top++;

            System.out.println("left "+ left +" right "+ right+ " top "+ top+ " botton "+ bottom);
            //Get every i in right col
            for(int j = top; j <= bottom ; j++){
                result.add(matrix[j][right]);
                System.out.println(matrix[j][right]);
                if(isHop){
                    value = matrix[j][right];
                }
                isHop = !isHop;
            }
            right--;

             // Check if there are more rows and columns to traverse
           
            System.out.println("left "+ left +" right "+ right+ " top "+ top+ " botton "+ bottom);
            //get every i in bottom
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                    System.out.println("w"+matrix[bottom][i]);
                    if(isHop){
                        value = matrix[bottom][i];
                    }
                    isHop = !isHop;
                }
              
            }
            bottom--;
           System.out.println("left "+ left +" right "+ right+ " top "+ top+ " botton "+ bottom);
            if (left <= right) {
                // Traverse the left colum
                for (int j = bottom; j >= top; j--) {
                    result.add(matrix[j][left]);
                    System.out.println(matrix[j][left]);
                    if(isHop){
                        value = matrix[j][left];
                    }
                    isHop = !isHop;
                }
               
            }
             left++;

           
        }
        System.out.println("last hop" + value);
        return result;
        
    }
}