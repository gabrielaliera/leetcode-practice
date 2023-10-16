class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
         // Replace this placeholder return statement with your code
        List<Integer> result = new ArrayList<>();

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }
       
        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1 ;


        while (left <= right && top <= bottom){
            
            System.out.println("Start left "+ left +" right "+ right+ " top "+ top+ " botton "+ bottom);
            //get every i in top row
            for(int i = left; i <= right; i++){
                result.add(matrix[top][i]);
                System.out.println(matrix[top][i]);
            }
            top++;

            System.out.println("left "+ left +" right "+ right+ " top "+ top+ " botton "+ bottom);
            //Get every i in right col
            for(int j = top; j <= bottom ; j++){
                result.add(matrix[j][right]);
                System.out.println(matrix[j][right]);
            }
            right--;

             // Check if there are more rows and columns to traverse
           
            System.out.println("left "+ left +" right "+ right+ " top "+ top+ " botton "+ bottom);
            //get every i in bottom
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                    System.out.println("w"+matrix[bottom][i]);
                }
              
            }
            bottom--;
           System.out.println("left "+ left +" right "+ right+ " top "+ top+ " botton "+ bottom);
            if (left <= right) {
                // Traverse the left colum
                for (int j = bottom; j >= top; j--) {
                    result.add(matrix[j][left]);
                    System.out.println(matrix[j][left]);
                }
               
            }
             left++;

           
        }
        return result;
        
    }
}