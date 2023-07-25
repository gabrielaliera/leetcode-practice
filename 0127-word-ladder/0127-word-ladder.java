/*

hot : dot
dot : hot dog loy
dog : dot
lot : dot log
log : lot dot
cog  dog log

undirected graph

how to connect:
  hot dot
  count = 0 ++ when h and f
  set -  o t 
  
  if(count <= 1){
     add to adj list
  }
  

//Build graph
  


*/
/*
General Idea: Traverse the wordList using BFS, starting from beginWord until we either reach the end or see endWord. As we visit each node, we add all adjacent nodes by looking up if a certain word exists in wordList.

1 . Create a set of all words in wordList, including endWord.
2. Create a set of visited nodes
3. Start BFS from beginWord, setting current word
    If current word is equal to endWord, return number of steps
    For each index of current word and each letter not equal to current word at index
        Create candidate word equal to currentWord
        Change candidate word at current index to new letter
        If it exists and not visited, traverse
4. If endWord was not found, return 0
*/


class Solution {
    private static final char[] letters = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // create a set of all words in wordList
    HashSet<String> wordsSet = new HashSet(wordList);
    HashSet<String> visited = new HashSet<>();
    Queue<Pair<String, Integer>> queue = new LinkedList();

    // start BFS from beginWord, setting currentWord
    queue.offer(new Pair<>(beginWord, 1));
    while (!queue.isEmpty()) {
      Pair<String, Integer> pair = queue.poll();
      String word = pair.getKey();
      int length = pair.getValue();
      if (word.equals(endWord)) {
        return length;
    }

    // for each index of current word and each letter not equal to current word at index
    for (int i = 0; i < word.length(); i++) {
        for (int j = 0; j < letters.length; j++) {
           if (word.charAt(i) != letters[j]) {
              String candidate = word.substring(0,i) + letters[j] + word.substring(i+1);
              if (wordsSet.contains(candidate) && !visited.contains(candidate)) {
                 queue.offer(new Pair<>(candidate, length + 1));
                 visited.add(candidate);
              }
           }
        }
     }
    }

    // if endWord was not found, return 0
    return 0;
    }
}