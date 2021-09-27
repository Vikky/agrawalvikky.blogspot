package array;

/**
 * A conveyor belt has packages that must be shipped from one port to another within days days.
 * The ith package on the conveyor belt has a weight of weights[i]. Each day, we load the ship with packages on the conveyor belt (in the order given by weights). We may not load more weight than the maximum weight capacity of the ship.
 * Return the least weight capacity of the ship that will result in all the packages on the conveyor belt being shipped within days days.
 */
public class ShipPackage {

    public static void main(String[] args) {
        ShipPackage obj = new ShipPackage();
        int days = obj.shipWithinDays(new int[]{500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500}, 1);
        System.out.println("Least weight capacity : "+days);
    }



    //Algo
    // find the max weight from the weights - O(n)
    // start from max;
    // use sliding window to  identify the max weight in a window (w) and number of windows < days
    // add 1 and repeat till all elements of array are processed


    public int shipWithinDays(int[] weights, int days) {

        int len = weights.length;
        int max = findMax(weights);
        int result =Integer.MAX_VALUE;


        for(int i= max; i<max*len ; i++)
        {
            Pair pair = process(weights, i, days, len);
            if(pair.flag)
            {
                result = pair.count;
                break;
            }
        }
        return result;
    }

    private Pair process(int[] arr, int max, int days, int len)
    {
        int count =0;
        int i=0;
        while(i<len)
        {
            int total =0;
            int j =i;
            for(; j <len;)
            {
                if(total+arr[j]<= max)
                {
                    total+= arr[j];
                    j++;
                }
                else
                    break;
            }
            i= j;
            count++;
            if(count >days)
                return new Pair(false, count);
        }
        return new Pair(true, max);
    }

    private int findMax(int[] arr)
    {
        int max =0;
        for(int a: arr)
        {
            if(a> max)
                max =a;
        }
        return max;
    }
}

class Pair
{
    boolean flag;
    int count;

    Pair(boolean flag, int count)
    {
        this.flag = flag;
        this.count = count;
    }

}
