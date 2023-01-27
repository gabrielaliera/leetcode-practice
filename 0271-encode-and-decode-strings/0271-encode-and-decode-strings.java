public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        
        String ans = "";
        for(String str : strs){
           String word = ""; 
           for(int i = 0;  i < str.length() ; i++){
               Character c = str.charAt(i);
               word = word.concat(c.toString());
              // word = word.concat(Character.toString((char)257));
              
           }    
           //  System.out.println(word);
            ans = ans.concat(word);
            ans = ans.concat(Character.toString((char)257));//spoace serves as deliminator
        }
        
     // System.out.println(ans);
        return ans;
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
      //  System.out.println(s);
        List<String> strs = new ArrayList<>();
        String word = "";
        for(int i = 0; i < s.length() ; i++){
             
             Character c = s.charAt(i);
          //  System.out.println(c+"-");
          //  if(c.equals((char)257)){ continue;}
            
            if(c.equals((char)257)){
                 strs.add(word);
                 word = "";
                continue;
             }
           
           word = word.concat(c.toString());
        //  System.out.println(word);
        }
        return strs;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));