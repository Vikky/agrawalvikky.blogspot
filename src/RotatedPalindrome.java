/*
 * Q: Check whether a String (rotated) is palindrome or not?
 */
/**
 * @author Vikky.Agrawal
 *
 */
public class RotatedPalindrome {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		RotatedPalindrome obj=new RotatedPalindrome();
		
		String str="1234321";
		System.out.println("whether String :"+str+" palindrome ?: "+obj.isPalindrome(str));
		
		String rotated="3432112";
		System.out.println("Whether roated string :"+rotated+ " palindrome ?:"+obj.isRotatedPalindrome(rotated));
	}
	/*
	 * O(n) solution to check whether a String palindrome or not?
	 */
	
	public boolean isPalindrome(String str){
		
		if(str!=null){
			char[] arr=str.toCharArray();
			
			for(int i=0, j=arr.length-1; i<arr.length/2 && i<=j ;i++, j--){
				if(arr[i]!=arr[j]){
					return false;
				}
			}			
		}else{ 
			//null String is a palindrome hence return true
			return true;
		}
		return true;
	}
	
	/*
	 * O(n^2) solution to check whether a rotated string is palindrome or not?
	 * helper function isPalindrome() takes O(n) time
	 * For each Substring loop iterates for O(n) hence total time : O(n^2)
	 */
	
	public boolean isRotatedPalindrome(String str){
		if(str!=null){
			for(int i=0;i<str.length();i++){
				String leftSubstring=str.substring(0,i);
				String rightSubstring = str.substring(i);
				//System.out.println("left :"+leftSubstring+" right : "+rightSubstring);
				if(isPalindrome(rightSubstring+leftSubstring)){
					return true;
				}			
			}		
		}else{
			return true;
		}
		return false;
	}

}
