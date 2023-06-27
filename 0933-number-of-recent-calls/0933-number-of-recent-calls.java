class RecentCounter {

    Deque<Integer> times;
    
    public RecentCounter() {
        this.times = new ArrayDeque<>();
        
    }
    
    public int ping(int t) {
        
        //Add ping to queue
        times.offer(t);
        
        // Remove all pings in the queue more than 3000 away from the new ping
        while(!times.isEmpty() && times.peekFirst() + 3000 < t){
            times.pollFirst();
        }
        
        return times.size();
      
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */