package search;


/**
 * Refer {@link RotatedArraySearch}
 */
public class BinarySearchRotated {

  public static void main(String[] args) {
      BinarySearchRotated obj = new BinarySearchRotated();

      int[] nums = new int[]{4,5,1};
      int num = obj.search(nums, 3);

        System.out.println("index of 0 :" +num);
  }

    // Sorted array - binary search
    // But rotated so can't do binary search.

    //Modified binary search.
    // -


    // [4,5,6,7,0,1,2]  num =3;

    // Find rotated index  O(log n)
    // binary search in subarrays O(log n)

    //Algo findRotatedindex:
    // start from mid. check condition for rotated index
    // check in left subarray or right subarray


    public int search(int[] nums, int target) {

        int len = nums.length;

        if(isRotated(nums, len))
        {
            int pivot = findRotatedIndex(nums, 0, len-1);
            if(target == nums[pivot])
                return pivot;
            else
            {
                if(target > nums[pivot] && target < nums[len-1])
                {
                    return binarySearch(nums, target, pivot, len-1);
                }
                else
                {
                    return binarySearch(nums, target, 0, pivot-1);
                }
            }
        }

        return binarySearch(nums, target,0, len-1);

    }

    private int binarySearch(int[] nums, int target, int start, int end)
    {
        if(start <0 || end <0 || start >=nums.length || end >=nums.length)
            return -1;

        int mid = (start+end)/2;
        if(target == nums[mid])
            return mid;
        if (target < nums[mid])
            return binarySearch(nums, target, start, mid-1);
        else if(target > nums[mid])
            return binarySearch(nums, target, mid+1, end);
        else
            return -1;
    }




    private int findRotatedIndex(int[] nums, int start, int end)
    {
        int len = nums.length;
        while(start <= end)
        {
            int mid = (start+end)/2;
            if(nums[mid] > nums[mid+1])
                return mid+1;
            else
            {
                if(nums[mid] < nums [start])
                    end = mid-1;
                else
                    start = mid+1;
            }
        }
        return 0;
    }

    private boolean isRotatedIndex(int[] nums, int index, int start, int end)
    {
        if(index==end)
        {
            return nums[index-1]>nums[index];
        }
        if(index ==start)
        {
            return nums[index+1]<nums[index];
        }

        return  nums[index-1]> nums[index] &&  nums[index+1] > nums[index];
    }


    private boolean isRotated(int[] nums, int len)
    {
        return nums[0] > nums[len-1];
    }




}
