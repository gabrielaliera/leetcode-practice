class Solution {
    public int maxProfit(int[] prices) {
         if ( prices == null || prices.length == 1){
            return 0;
        }

        int minPrice  = prices[0];
        int maxProfit = 0;


        for (int sell = 1; sell < prices.length; sell++){

            int sellPrice = prices[sell];

            int windowProfit = sellPrice - minPrice;

            if(sellPrice < minPrice){
                minPrice = sellPrice;
            }
            maxProfit = Math.max(maxProfit, windowProfit);
        }

        return maxProfit;
    }
}