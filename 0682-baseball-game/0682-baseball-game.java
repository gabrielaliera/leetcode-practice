class Solution {
    public int calPoints(String[] operations) {
        
        Stack<Integer> scores = new Stack<>();
        
        for(String s : operations){
            if(s.equals("+")){
                int num1 =  scores.pop();
                int num2 =  scores.peek();
                 scores.push(num1);
                 scores.push(num1 + num2);
                
            } else if(s.equals("D")){  //record new socre that double the previous score
                
                scores.push(2* scores.peek());
                
            } else if (s.equals("C")){ //Invilidate prevoious score
                scores.pop();
            } else {
                scores.push(Integer.valueOf(s));
            }
        }
        
        int sum = 0;
        while(!scores.isEmpty()){
            sum += scores.pop();
        }
        
        return sum;
        
    }
}