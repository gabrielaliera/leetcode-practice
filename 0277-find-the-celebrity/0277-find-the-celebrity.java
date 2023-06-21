/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */
/*

U:
Inpit n = nuimber of people
input: array of arr
  i j k
i 1 1 0
j 0 1 0 - this is celebrity has all zero except i = 
k 1 1 1

  i j k
i 1 0 1
j 1 1 0  No celebrity 
k 0 1 1

Edge  n = 0 zero people return -1

Ouput : labe of celebrity( row index)  or -1

Match: 
 Brute: o(n^2)   n=3 -- 9 calls 
   for each person, 
      for each other person call known (n , index)
   

*/
public class Solution extends Relation {
    public int findCelebrity(int n) {
        // Edge Case
        if (n <= 0) return -1;
        if (n == 1) return 0;

        Stack<Integer> potentialCelebrity = new Stack<>();

        // Add all people to the stack
        for (int i = 0; i < n; i++) {
            potentialCelebrity.push(i);
        }
        
        int a = 0;
        int b = 0;

        while (potentialCelebrity.size() > 1) {
            a = potentialCelebrity.pop(); 
            b = potentialCelebrity.pop();

            if (knows(a, b)) 
                // a knows b, so a is not the celebrity, so return b
                potentialCelebrity.push(b);
            else 
                // a doesn't know b, so b is not the celebrity, but a may be
                potentialCelebrity.push(a);
        }

        // double check the potential celebrity
        int c = potentialCelebrity.pop();

        for (int i = 0; i < n; i++)
            // c should not know anyone else
            if (i != c && (knows(c, i) || !knows(i, c)))
                return -1;

        return c;
     }
}