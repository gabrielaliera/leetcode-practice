class MyHashSet {

    Bucket[] bucketArray;
    
    public MyHashSet() {
        bucketArray = new Bucket[1000];
        for(int i=0;i<bucketArray.length;i++){
            bucketArray[i]= new Bucket();
        }
    }
    
    public void add(int key) {
        int bucket = key % 1000;
        bucketArray[bucket].insert(key);
    }
    
    public void remove(int key) {
        int b = key % 1000;
        bucketArray[b].remove(key);
    }
    
    public boolean contains(int key) {
        int b = key % 1000;
        return bucketArray[b].exists(key);
    }
}

class Bucket{
    LinkedList<Integer> container;
    
    public Bucket(){
        container = new LinkedList<>();
    }
    
    public void insert(int key){
        int index = container.indexOf(key);
        if(index == -1)
        container.addLast(key);
    }
    
    public void remove(Integer key){
        if(container.contains(key)){
            container.remove(key);
        }
    }
    
    public boolean exists(int key){
        return container.contains(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */