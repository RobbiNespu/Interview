
public class Max {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] prices={5};
		System.out.println(maxProfit2(prices));
		System.out.println(maxProfit(prices));
		
		
		/**

			  [1,   3,  5,  7],
			  [10, 11, 16, 20],
			  [23, 30, 34, 50]

	     **/
		
		
		int landscape[][] = new int[3][4];
		landscape[0][0] = 1;
		landscape[0][1] = 3;
		landscape[0][2] = 5;
		landscape[0][3] = 7;
		landscape[1][0] = 10;
		landscape[1][1] = 11;
		landscape[1][2] = 16;
		landscape[1][3] = 20;
		landscape[2][0] = 23;
		landscape[2][1] = 30;
		landscape[2][2] = 34;
		landscape[2][3] = 50;
		System.out.print(searchMatrix(landscape, 6));
	}
	
	public static int maxProfit2(int[] prices) {
     int diff=0;
     int maxprofit=0;
     int i=0;
     int j=1;
     while(j<prices.length){   
          if(prices[j]-prices[i]<0)
              i=j;
          else{
             diff = prices[j]-prices[i];
             if(diff > maxprofit)
                 maxprofit = diff; 
          } 
          j++;
     }
     return maxprofit;
  }
	public static int maxProfit(int[] prices) {
	        int profit=0, mProfit=0;
	        int s=0, e=1;
	        while(e<prices.length){
	            if(prices[e] > prices[s]){
	                profit=prices[e]-prices[s];
	                if(profit>mProfit) mProfit=profit;
	                e++;
	            }
	            else{
	                s=e;
	                e=s+1;
	            }
	        }
	        return mProfit;
	}
	
	
	/**
	Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
		Integers in each row are sorted from left to right.
		The first integer of each row is greater than the last integer of the previous row.
		For example,
		Consider the following matrix:
		[
		  [1,   3,  5,  7],
		  [10, 11, 16, 20],
		  [23, 30, 34, 50]
		]
		Given target = 3, return true.
     **/
	
    public static boolean searchMatrix(int[][] matrix, int target) 
    {
    	// the most up- right corner is i = 0 , j= matrix[i].length-1(number of column)
    	int i =0, j=matrix[i].length-1;
    	
    	// going down
        while(target > matrix[i][j] && i < matrix.length-1)
        {
        	i++;	
        }
        if(target == matrix[i][j])
        	return true;
        // going left
        while(target  < matrix[i][j] && j>0)
        {
        	j--;	
        }

        if(target == matrix[i][j])
        	return true;
        else
            return false;
    }

	
	
}
