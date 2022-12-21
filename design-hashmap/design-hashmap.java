class MyHashMap {
    
    private Bucket[] bucketArray;
    private int primeSize = 1009;
    
    public MyHashMap() {
        bucketArray= new Bucket[primeSize];
        for(int i=0;i<bucketArray.length;i++){
            bucketArray[i] = new Bucket();
        }
    }
    
    public int getPostContainer(int key,int hashIndex){
        LinkedList<Entry> container = bucketArray[hashIndex].getContainer();
        
        if(container == null){
            return -1;
        }
        for(int i = 0; i < container.size(); i++){
            if(container.get(i).getKey() == key){
                return i;
            }
        }
        return -1;
    }
    
    
    public void put(int key, int value) {
        int hash = key % primeSize;
        if(bucketArray[hash].exists(key)){
            int index = getPostContainer(key,hash);
            bucketArray[hash].set(index,key,value);
        }else {
            bucketArray[hash].add(key,value);
        }
    }
    
    public int get(int key) {
        int hash = key % primeSize;
        int index = getPostContainer(key,hash);
        
        if(!bucketArray[hash].exists(key)){
            return -1;
        } else{
            return bucketArray[hash].get(index,key);
        }
    }
    
    public void remove(int key) {
        int hash = key % primeSize;
        int index = getPostContainer(key,hash);
        if(index != -1){
            bucketArray[hash].delete(index,key);
        }
    }
}

class Bucket{
    private LinkedList<Entry> container;
    private int size = 0;
    
    Bucket(){
        container = new LinkedList<>();
    }
    
    public LinkedList<Entry> getContainer(){return container;}
    
    public void add(int key, int value){
        Entry pair = new Entry(key, value);
        container.addFirst(pair);
        size++;
    }
    
    public void set(int index,int key,int value){
        Entry pair = new Entry(key,value);
        container.set(index,pair);
        
        // for(Entry pair: container){
        //     if(pair.getKey() == key){
        //         int index = container.indexOf(pair);
        //         container.set(index,pair);
        //     }
        // }
    }
    
    public int get(int index,int key){
        
      //  int value = -1;
        return container.get(index).getValue();
        // for(Entry pair: container){
        //     if(pair.getKey() == key){
        //         return pair.getValue();
        //     }
        // }
        // return value;
    }
    
    public void delete(int index, int key){
        Entry pair = container.get(index);
        container.remove(pair);
        // for(Entry pair: container){
        //     if(pair.getKey()==key){
        //         container.remove(pair);
        //     }
        // }
        size--;
    }
    
    public boolean exists(Integer key){
        for(Entry pair: container){
            if(pair.getKey() == key){
                return true;
            }
        }
        return false;
    }
    public int size(){return size;}
}

class Entry{
    private int K;
    private int V;
    
    Entry(int key, int value){
        this.K = key;
        this.V = value;
    }
    
    public void setKey(int num){K=num;}
    public void setValue(int num){V=num;}
    public int getKey(){return K;}
    public int getValue(){return V;}
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */