class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        //Edge case empty array
		if(nums.length == 0){
			return new int[0];
		}

		//W is greater than array size
		if(k > nums.length){
			k = nums.length;
		}
		
		int[] res = new int[nums.length - k + 1];
		int j = 0; 
		//Maintain index of max in decreases
		Deque<Integer> q = new LinkedList<>();

		for(int i = 0; i < nums.length; i ++){
			int curValue = nums[i];
			//clean up - remove if deque index has less values than cur val
			while(!q.isEmpty() && curValue >= nums[q.peekLast()]){
				q.removeLast();
			}
			//Add index
			q.offer(i);

			//Remove first index if out of window
			if( i - q.peekFirst() + 1 > k){
				q.removeFirst();
			}

			//Add to result for window
			if(i >= k - 1){
				res[j++] = nums[q.peekFirst()];
			}

		}

		return res;
        
    }
    
    public static int[] findMaxSlidingWindow(int[] nums, int w) {

		int[] ans = new int[nums.length - w + 1];
		Deque<Integer> q = new LinkedList<>(); //index

		int left = 0;
		int right = 0;
		int j = 0;

		while (right < nums.length){
			//pop smaller values from q
			while( !q.isEmpty() && nums[q.peekLast()] < nums[right]){
				q.removeLast();
			}
			q.offer(right);

			if (left > q.peekFirst()){
				q.removeFirst();
			}

			if( right + 1 >= w){
				ans[j++] = nums[q.peekFirst()];
			}
		}

		
		return ans;
    }
}