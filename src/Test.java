
public class Test {

	/**
	 * @param args
	 */
	
	static class Draw extends Thread{
		
		@Override
		public void run(){
			
		}
	}
	
	
	public static void main(String[] args) throws Exception {
		
		int arr[]=new int[]{2,3,9,1,8,7,10};
		System.out.println(arr.length);
		
		Thread t=new Draw();
		t.run();
		
		t.sleep(100);
		
		t.join();
	}
	
	
	public int findMax2(int[] arr){
		if(arr==null || arr.length ==1){
			return -1;
		}
		
		if( arr.length ==2){
			int maxx =  arr[0] >arr[1] ? arr[1]:arr[0];
			System.out.println("max 2 is :"+maxx);
			return maxx;
		}
		
		
		
		
		int max=arr[0];
		int max2=arr[1];
		
		max = max>max2 ? max : max2;
			
		for(int i=2;i < arr.length ; i++){
			
			if(arr[i] > max2){
				if(arr[i] > max){
					max2=max;
					max=arr[i];
				}else{
					max2=arr[i];
				}
			}
			
		}
		System.out.println("Max is :"+max +" second max is : "+ max2);
		return max2;
	}

}
