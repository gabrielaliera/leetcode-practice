class Logger {

    HashMap<String, Integer> map;
    int TIME = 10;
    
    public Logger() {
        map = new HashMap<>();
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
         if(map.containsKey(message)){
            
            int prevTimeStamp = map.get(message);
            
            if(prevTimeStamp > timestamp){
                return false;
            } 
            map.put(message, timestamp +TIME);
         } else {
             map.put(message, timestamp + TIME );
         }
        return true;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */