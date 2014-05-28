import java.util.ArrayList;

import java.util.Date;

 

public class Prime2 {

              public static void main(String[] args) {

              ArrayList<Integer> primeSet = new ArrayList<Integer>();

              primeSet.add(2);

              

              long startTime = new Date().getTime();

              int n=1000000;

              

              for (int i = 3; i <= n; i+=2) {

                     if (isPrime(i,primeSet))

                           primeSet.add(i);

              }

              

              

              long endTime = new Date().getTime();

              long duration = endTime - startTime;

              

              System.out.println("No of primes below : "+n+ " are : " +primeSet.size());

              

              System.out.println("Time taken is : " + duration+" milliseconds");

              

       }

 

       public static boolean isPrime(int num,ArrayList<Integer> primeSet) {

              boolean prime = true;

              int limit = (int) Math.sqrt(num);

 

              for (int i = 0; primeSet.get(i) <= limit; i++) {

                     if (num % primeSet.get(i) == 0) {

                           prime = false;

                           break;

                     }

              }

 

              return prime;

       }

 

}

