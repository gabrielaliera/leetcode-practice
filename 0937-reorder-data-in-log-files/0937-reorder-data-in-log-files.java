/*

Output

num list : relative ourde

Match:
 hashmap- no doesnt keep order

Plan

for each string 
  use pointer to find space
    if next char is letter
      add the leeter list
      else add to num list

//Sort letter list
 List<List>
   




cont letterList + numList

*/


class Solution {
    public String[] reorderLogFiles(String[] logs) {
        
        List<String> letterLogs = new ArrayList<>();
        List<String> digitLogs = new ArrayList<>();
        
        //Separate letter and digits logs
        for(String s : logs){
            //check last char to see if letter-log or digit-log
            if (Character.isDigit(s.charAt(s.length() - 1))){
                digitLogs.add(s);
            } else {
                letterLogs.add(s);
            }    
        }
        
        //Sort letter logs
        Collections.sort(letterLogs, new Comparator<String>() {
            @Override
            public int compare(String log1, String log2) {
                // Split the logs into identifier and content
                int index1 = log1.indexOf(' ');
                String id1 = log1.substring(0, index1);
                String content1 = log1.substring(index1 + 1);

                int index2 = log2.indexOf(' ');
                String id2 = log2.substring(0, index2);
                String content2 = log2.substring(index2 + 1);

                // Compare the contents of the letter logs
                int cmp = content1.compareTo(content2);
                if (cmp != 0) {
                    return cmp; // Contents are different, sort by content
                }

                // Contents are the same, sort by identifier
                return id1.compareTo(id2);
            }
        });

        
        //Add digit logs to sorted Letter log
        String[] result = new String[logs.length];
        
       int index = 0;
        for (String letterLog : letterLogs) {
            result[index++] = letterLog;
        }
        for (String digitLog : digitLogs) {
            result[index++] = digitLog;
        }
        return result;
    }
}