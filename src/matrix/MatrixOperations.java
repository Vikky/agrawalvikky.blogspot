package matrix;

/**
 * @author Vikky.Agrawal
 * Problems related to Matrix
 */
public class MatrixOperations {

	int[][] arr={{9,15,18},{11,19,20},{17,21,25}};
	int length;
	
	
	MatrixOperations(){
		
	}
	
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		MatrixOperations obj=new MatrixOperations();
		obj.operate();
	}

	
	
	public void operate(){
		this.printMatrix(arr);
		
		int k=4;
		System.out.println(k+ " th largest : "+findKthLargest(k));
		
		this.multiply(arr);
		
	}
	
	public int findKthLargest(int k){
		
		if(k==1){
			return arr[0][0];
		}
		
		
		
		int length=arr.length;	
		if(k>(length*length)){
			return -1;
		}
		
		
		int temp=k;
		
		for(int i=0,j=0;  temp>0   ; ){
			System.out.println("i :"+i +" and j :"+j);
			
			if(arr[i][j+1] > arr[i+1][j]){
				i++;
				if(i>=length){
					i=0;
				}
			}else{
				j++;
				if(j>=length){
					j=0;
				}
			}
			
			if(--temp == 0){
				return arr[i][j];
			}
		}
		System.out.println("reached out of loop");
		return -1;
		
	}
	
	
	
	
	
	//Helper functions:(square matrix)
	public void printMatrix(int [][] arr){	
		int m=arr.length;
		
		for(int i=0;i<m;i++){
			for(int j=0;j<m;j++){
				System.out.print(arr[i][j]+" ");
			}
			System.out.println(" ");
		}
	}
	
	//Multiply with itself
	public void multiply(int [][] arr){
		
		int m=arr.length;
		int multiplied [][] =new int[m][m];
		int sum=0;
		for(int i=0;i<m;i++){
			for(int j=0;j<m;j++){
				for(int k=0;k<m;k++){
					multiplied[i][j]+= arr[i][k]*arr[k][j];		
				}
				
			}
		}
		System.out.println("Multiplied array :");
		printMatrix(multiplied);
	}
	
}
