class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        
    String aToz = "abcdefghijklmnopqrstuvwxyz";
    HashMap<Character,Integer> lettersIndex = new HashMap<>();
    //Fill hashmap
    for(int i = 1; i <= aToz.length(); i++){
      lettersIndex.put(aToz.charAt(i-1), i);
    }

    //Find total shifts
    char[] letters = s.toCharArray();
    int totalShifts = 0;
    for(int i = 0 ; i < shifts.length ; i++){
      
      totalShifts += shifts[i] % 26;
    }

    //System.out.println("totalShift: "+ totalShifts);
    //Iterate through arr and change letter
    for(int i = 0; i < shifts.length ; i++ ){
      
      Character oldLetter = letters[i];
     // System.out.println("old: "+ oldLetter + " shifts: "+ totalShifts);
      //Find num value to index
      int numLetter = lettersIndex.get(oldLetter);
     // System.out.println("old numLetter: "+ numLetter);
      numLetter += totalShifts;
      numLetter = numLetter % 26;
      //System.out.println("numLetter: "+ numLetter);
      
        //Change to correct letter
      Character newLetter = aToz.charAt(numLetter == 0 ? 25 : numLetter - 1);

      //System.out.println(oldLetter + " "+ newLetter);
      letters[i] = newLetter;
      totalShifts -= shifts[i] % 26;
     
    }
    
    return new String (letters);
        
    }
}