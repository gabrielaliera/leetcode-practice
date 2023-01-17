class Solution {
    public boolean checkIfExist(int[] arr) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        //add values to hashmap
        for(int i = 0; i < arr.length ; i++){
            //value, index
            map.put(arr[i], i);
            System.out.println(" map.get(i) "+ map.get(i));
        }
        
        //check if condition exist
        for(int j = 0 ; j < arr.length ; j++){
           // int j = map.get(i) / 2;
            int doubleN = 2 * arr[j];
            System.out.println("arr[j] "+arr[j]+ " map.get(j) "+ map.get(j));
            if(map.containsKey( 2 * arr[j]) && j != map.get(2*arr[j])){
                return true;
            }
        }
        return false;
        
    }
}