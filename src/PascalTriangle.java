public class PascalTriangle {

	int arr[];
	private int N;

	public static void main(String arg[]) {
		PascalTriangle obj = new PascalTriangle(5);
		int output[]=obj.fillUsingPermutation();
		for(int a :output){
			System.out.println(a);
		}
	}

	public PascalTriangle(int N) {
		this.N=N;
		this.arr = new int[this.getSize(N)];
	}

	private int getSize(int N) {
		int i = 0;
		while (N > 0) {
			i += N--;
		}
		return i;
	}

	private int[] fillUsingPermutation() {
		int k=0 ;
		for (int n = 0; n < N && k<arr.length; n++) {
			int r=0;
			while(r <= n){
				arr[k]= fact(n)/(fact(r)*fact(n-r));
				r++;
				k++;
			}
		}

		return this.arr;
	}

	public int fact(int n){
		if(n==0){
			return 1;			
		}else{
			return n*fact(n-1);
		}
	}

}
