package array;

/**
 * Given an array of positive numbers and a positive number ‘k’, find the maximum sum of any contiguous subarray of size ‘k’.
*/


public class SubArrayMaxSum {
    public static void main(String[] args) {
        System.out.println("Hello, world!");
        
        int[] arr = new int[]{2, 1, 5, 1, 3, 2};
		SubArrayMaxSum obj = new SubArrayMaxSum();
        System.out.println("max sum:"+obj.getSum(arr,3));
        
        
        
    }
    
public int getSum(int[] arr, int k)
{


//int [] array = new int[] {1,2 4 ,5 , 9,3 }

// loop through k 
// store that in sum 
// keep a pointer at start
// from k+1
// add the next and subtract the last pointer 


// boundary conditions
if(arr ==null)
	return -1 ;


int length = arr.length;

if(length ==0)
	return -1;

if (k<=0) {
	return -1;
}

int maxsum=0;
int sum =0;



int start=0;
int end=0;
//if length is <=k
if(length <=k)
{
	while(end++<length)
	{
		sum = sum+arr[end];
	}
	return sum;
}


// start and end index
while(end++<k)
{
	sum = sum+arr[end];
}
maxsum =sum;

for (int i=end; i<length; i++)
{
	sum = sum+arr[i]-arr[start];
	start++;
	maxsum = Math.max(sum, maxsum);
}

return maxsum;


} 
    
    
}
