package misc;

import java.util.ArrayList;
import java.util.Date;

public class PrimeCount {

	/**
	 * @param args
	 * @Author Vikky Agrawal
	 */
	public static void main(String[] args) {
		
		int input=1000000;
		ArrayList<Integer> prime=new ArrayList<Integer>();		
		
		prime.add(3);
		prime.add(5);
		
		int primes= 3;
		
		//long start=System.currentTimeMillis();
		long startTime = new Date().getTime();

		boolean temp=false;
		for(int i=7; i<=input; i+=2){			
				temp=false;				
				int index=0;
				int j=prime.get(index);
				int sqrt=(int)(Math.floor(Math.sqrt(i)));
				for(; j<=sqrt; ){	
					int k=i%j;					
					if( k == 0){
						temp=true;
						break;
					}
					j=prime.get(++index);
				}
				if(!temp){	
					if(i <(input/2)){
						prime.add(i);
					}					
					primes++;
				}
			}			
		
		long endTime = new Date().getTime();
        long duration = endTime - startTime;

        System.out.println("Time taken is : " + duration+" milliseconds");
		System.out.println("Number of prime count for input : "+input+" is : "+primes);	
					
	}
}
