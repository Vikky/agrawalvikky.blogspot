package array;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Given a string, find the length of the longest substring in it with no more than K distinct characters.
 */


public class LongestSubStringWithK
{

    public static void main(String[] args) {
        
        
        LongestSubStringWithK obj = new LongestSubStringWithK();
        String str ="cbbebi";
        int k = 3;
        
        System.out.println("Longest subArray : "+obj.getLongestSubString(str, k));
    }
    
    
   
//Find the longest substring with k unique characters in a given string
//Input: String="araaci", K=2 Output: 4
//Explanation: The longest substring with no more than '2' distinct characters is "araa".

//Algo:
// start and end pointer and maintain a count between those 
// Check if char is in set, if no 
//    increment the counter 
// if counter >k
    // increase the start pointer.
    // reset counter and remove from set till start < next
// otherwise put in set and increase counter


public int getLongestSubString(String str, int k)
{

    if(str==null)
        return 0;
        
     int len  = str.length();
     if(k==len)
         return len;
         
     int next =0;
     int start =0;
     int count =0; //unique
     int max =0;
     Map<Character, Integer> map = new HashMap();
     
     
     for(; next< len; )
     {
         while(count<=k && next <len)
         {
             char c = str.charAt(next);
             next++;
             
             if(map.containsKey(c))          
                 map.put(c, map.get(c)+1);
             else
             {
                 map.put(c,1);
                 count++;
             }
         }
         max = max < next-start-1 ? next-start-1 : max;
         
         // reset pointers and Map
         while(map.size() > k && start <next)
         {
             char c = str.charAt(start);
             start++;
             if(map.containsKey(c))
             {
                 int freq = map.get(c);
                 if(freq==1)
                     map.remove(c);
                 else
                 {
                     map.put(c, freq-1);
                 }    
             }
         }
         count = map.size();
     }
    return max;
}
    
}