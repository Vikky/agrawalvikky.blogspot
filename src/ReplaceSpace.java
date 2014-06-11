/**s
 * @author Vikky.Agrawal
 * Replace space with %20 in char array in-place.
 * assuming enough space to accommodate %20
 */
public class ReplaceSpace {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ReplaceSpace obj=new ReplaceSpace();
		
		String str= "hey hi hello";
		char[] arr=str.toCharArray();
		
		obj.removeSpace(arr, 15);

	}
	
	public void removeSpace(char[] arr, int length){
		
		if(arr==null)
			return;
		int spaceCount=0;
		for(int i=0; i<arr.length ;i++){
			if(arr[i]==' '){
				spaceCount++;
			}
		}
		char newarr[]=new char[arr.length+(spaceCount*2)];
		
		
		for(int i=arr.length-1; i>=0;i-- ){
			int k=i+spaceCount*2;
			if(arr[i]==' '){
				newarr[k]='0';
				newarr[k-1]='2';
				newarr[k-2]='%';
				spaceCount--;
				
			}else{
				newarr[k]=arr[i];
				
			}
		}
		
		
		for(int i=0; i<newarr.length ;i++){
			System.out.println(newarr[i]+" ");
		}
		
		
	}
	
	

}
