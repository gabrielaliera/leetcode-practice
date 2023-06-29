/*
Understand
Input:
 array never empty at least 2 rocks
 size cant be zero
 
 Direction 
  only forward once so only neigbors can collide
  
 Output
 
 Edge - 2 negative
 [-5 -5] never collides [-5 -5]
 edge
 -5 -5 5 
 + + not collide
 - - not collide
 - + not collide
 + -  collide
 
 Match -
  arraylist to help with dynamic sizes
  2 pointers for 2 rocks
  hashmap- maybe but probably not
  sliding window- no
  
  Stack
 
 plan'
  two pointer o(n)
  iterate until pointer2 reaches end --- issues may need to iterate through again
                      10 2 -5
                      10 -5
                      10
  
  Compare signs
     if collide 
       check find new size
       add to results
     else 
        add pointer1 to result

    plan 2: (STACK)
    
    Iterate through rocks
    
        if rock is negative add to stack and continue util is doesnt crash
   
    
 + + not collide
 - - not collide
 - + not collide
 + -  collide
*/



class Solution {
    
    public int[] asteroidCollision(int[] asteroids) {
        
        Stack<Integer> stack = new Stack<>();
        
        for(int rock : asteroids){
            
            //Case + | - collision
            if(!stack.isEmpty() && rock < 0 && stack.peek() > 0) {

                int prevRock= stack.peek();
            
                    
                //Large neg rock crashes smaller rocks
                while(!stack.isEmpty() && prevRock > 0 && prevRock < Math.abs(rock)){
                    stack.pop();
                     if (!stack.isEmpty()) {
                        prevRock = stack.peek();
                    }
                }
                      
                if(stack.isEmpty() || prevRock < 0) { // no more rocks or meets neg rock
                    stack.push(rock);
                } else if (prevRock == Math.abs(rock)){
                    stack.pop(); // both destoried
                }
  
          //all other cases (++ -- -+)
            } else {
                stack.push(rock);
            }
           
        }
        
        int[] array = new int[stack.size()];

        // Convert stack to array
        for (int i = array.length - 1; i >= 0; i--) {
            array[i] = stack.pop();
        }
        
        return array;
        
    }
    /*public int[] asteroidCollision(int[] asteroids) {
        
        int rockA = 0;
        List<Integer> result = new ArrayList<>();
        
        for(int rockB = 1 ; rockB < asteroids.length ; rockB++){
            int signA = ( asteroids[rockA] > 0 ? 1 : -1);
            int signB = ( asteroids[rockB] > 0 ? 1 : -1);
            
            //Just for collision
            if(signA == 1 && signB == -1) {
                
                int sizeA = Math.abs(asteroids[rockA]);
                int sizeB = Math.abs(asteroids[rockB]);
                
                if (sizeA > sizeB) {
                    result.add(asteroids[rockA]);
                } else if ( sizeA < sizeB){
                    result.add(asteroids[rockB]);
                }
             
            } else {
                result.add(asteroids[rockA]);
            }
            //move pointer a
            rockA++;
        }
        
        return result.stream().mapToInt(i -> i).toArray();
        
    }
    */
}