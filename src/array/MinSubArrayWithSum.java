package array;

/**
 * Given an array of positive numbers and a positive number ‘S’, 
 * find the length of the smallest contiguous subarray whose sum is greater than or equal to ‘S’. Return 0, if no such subarray exists.
*/

public class MinSubArrayWithSum {
    public static void main(String[] args) {
        System.out.println("Hello, world!");
        
        int[] arr = new int[]{2, 1, 5, 2, 3, 2};
		MinSubArrayWithSum obj = new MinSubArrayWithSum();
        System.out.println("smallest subarry:"+obj.getMinLngthSubArray(arr,7));
        
        
        
    }
    
public int getMinLngthSubArray(int[] arr, int S)
{

	//Boundary conditions
	if(arr==null || arr.length==0)
		return 0;

	int length = arr.length;

	// maintatin two pinters, start and end
	// move end till Sum becomes greater than equal to S
	// calculate length (end-start+1)
	// if sum > S , move start pointer till Sum <S;
	// check if Sum == S update length and break;



	int start=0, end =0;
	int sum =0;
	int len =0;
	int minlen =0;

	while(end<length)
	{
		while(sum <= S && end < length)
		{
			sum = sum+arr[end];
			end++;
		}
		if (sum<S) {
			return Math.max(minlen,0);
		}

		if(sum >=S)
		{
			while(sum>S && start<end)
			{
				sum = sum-arr[start];
				start++;
			}
			if (sum == S) 
			{
				len = end-start;
                if(len>0){
    				minlen = minlen==0 ? len : (len < minlen ? len :minlen);
                }
			}
		}

	}
	return minlen;
}
    
    
}
