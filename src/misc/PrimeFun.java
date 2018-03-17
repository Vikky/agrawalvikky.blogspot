package misc;

public class PrimeFun

{

	public static void main(String[] args)

	{
		final long startTime = System.currentTimeMillis();
		final int limit = 10000000;

		boolean[] isNotPrime = new boolean[limit + 1];

		for (int i = 2; i <= Math.sqrt(limit); i++)
		{
			if (!isNotPrime[i])
			{
				for (int j = i; j * i <= limit; j++)
				{
					isNotPrime[j * i] = true;
				}
			}
		}

		int noPrimeNo = 0;

		for (int i = 2; i <= limit; i++)
		{
			if (!isNotPrime[i])
				noPrimeNo++;
		}

		System.out.println("No of prime number from 1 till " + limit + " is: " + noPrimeNo);
		long endTime = System.currentTimeMillis();
		System.out.println("Time in mili sec: " + (endTime - startTime));
	}
}

