/*

Maybe add all students to queue  / sandwich in stack//can leave in array
for(student : student)
  studentQueue.addLast(studnet)



//student takes sandwhich
student.removeFirst()
sandwhicPtr++

//student leave sandwhich move to end of queue
queue.add(queue.removeFirst())


//all student not want the sandwhich
lastptr == queue.top && sandwhich[i] == quue.top
  return quque.size()



return queue.size()
*/


class Solution {
//     public int countStudents(int[] students, int[] sandwiches) {
        
//         Queue<Integer> queue = new LinkedList<>();
//         int i = 0; 
        
//         //add all student to queue
//         for(int stu : students){
//             queue.add(stu);
//         }
        
//         int returnCount = 0;
        
//         while(!queue.isEmpty() && i < sandwiches.length && returnCount < queue.size()){
            
//             //student takes sandwhich
//             if(sandwiches[i] == queue.peek()){
//                 queue.remove();
//                 i++;
//                 returnCount = 0;
//             //student moves to end of queue
//             } else {
//                 queue.add(queue.remove());
//                 returnCount++;
//             }
            
//         }
        
        
//         return queue.size();
        
        
//     }
     public int countStudents(int[] students, int[] sandwiches) {
        int[] s = new int[2];
        for (int i = 0; i < students.length; i++) {
            s[students[i]] ++;
        }

        for (int i = 0; i < sandwiches.length && s[sandwiches[i]] != 0; i++) {
            System.out.println(i);
            s[sandwiches[i]] --;
        }

        return s[0] + s[1];
    }
}