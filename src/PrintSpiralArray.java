/**
 * @author Vikky.Agrawal
 * 
 */
public class PrintSpiralArray {

	int[][] nums;

	PrintSpiralArray() {
		nums = new int[][] { { 1, 2, 3, 10 }, { 4, 5, 6, 20 }, { 7, 8, 9, 30 } };

	}

	public static void main(String[] args) {
		
		PrintSpiralArray obj=new PrintSpiralArray();
		obj.print(obj.nums); 	
		
		int [][]arr=new int[3][4];
		System.out.println(arr[0].length);
		
		
		
	}
	
	
	public void print(int [][] arr){
		
		int rowlen=arr.length;
		int collen=arr[0].length;
		
		
		int k=0,l=0;
		int i=0;
		
		while(k < rowlen && l < collen ){
		
			for(i=k ;i<collen; i++ ){
				System.out.println(arr[k][i]+" ");
			}
			k++;
			
			for(i=l; i<rowlen;i++){
				System.out.println(arr[i][collen-1]+" ");
			}
			collen--;
			
			
			
		}
	}
	

}
