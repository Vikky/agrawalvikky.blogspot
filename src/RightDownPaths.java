/**
 * @author vikky.agrawal
 *
 */
public class RightDownPaths {

	
	int[][] arr;
	int length;
	
	
	RightDownPaths(){
		arr=new int[4][4];
		this.length=4;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new RightDownPaths().operate();

	}

	
	public void operate(){
		this.calculate(arr);
	}
	
	
	
	
	public void calculate(int[][] arr){
		
		System.out.println("initial array :");
		printArray(arr);
		
		
		int m=length-1;
		
		arr[m][m]=0;
		
		for(int k=0;k<length;k++){
			arr[k][m]=1;
			arr[m][k]=1;
		}
		
		
		for(int i=m-1; i>=0;i--){
			
			for(int j=m-1;j>=0;j--){
						
				arr[i][j]=arr[i+1][j]+arr[i][j+1];
			}
			
		}
		System.out.println("Array after processing");
		printArray(arr);
		
		
		System.out.println("Total number of paths going right/down from [0,0] is = "+arr[0][0]);
		
	}
	
	public void printArray(int [][] arr){	
		int m=length;
		
		for(int i=0;i<m;i++){
			for(int j=0;j<m;j++){
				System.out.print(arr[i][j]+" ");
			}
			System.out.println(" ");
		}
	}
	
}
