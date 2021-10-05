/**
 * Given an array of positive numbers and a positive number ‘S’, 
 * find the length of the smallest contiguous subarray whose sum is greater than or equal to ‘S’. 
 * Return 0, if no such subarray exists.
 */


public class SmallestSubarray {
    public static void main(String[] args) {
        
        
        SmallestSubarray obj = new SmallestSubarray();
        
       int[] num= new int[]{2, 1, 5, 2, 3, 2};
        int sum = 7;
        
        System.out.println("Smallest subArray : "+obj.getSmalletArray(num, sum));
    }
    
    public int getSmalletArray(int[] numbers, int sum)
    {

        if(sum ==0)
            return sum;

        int len = numbers.length;
        int min = Integer.MAX_VALUE;
        int start =0;
        int add =0;

        for(int next=0; next<len; )
        {
            while(add<=sum && next< len)
            {
             add += numbers[next];
             next++;
            }
            if(add==sum)
            {
                min =min < next-start ? next-start :min;
            }
            else
            {
                while(add > sum && start < next)
                {
                    add-= numbers[start];
                    start ++;
                }
                //System.out.println("start "+start+" next "+next+ " add "+add);
                if(add==sum)
                {
                    
                    min =min < next-start ? next-start :min;
                }
            }

            if(next== len)
                break;

        }
        if(min == Integer.MAX_VALUE)
            return 0;
            
        return min;    
    }
    
    
    
}