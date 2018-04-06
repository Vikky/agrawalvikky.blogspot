package array;

import java.util.Scanner;

/**
 * Created by viagrawal on 4/5/18.
 */
public class ChaoticQueue
{

	static void minimumBribes(int[] a) {

		int bribes =0;
		boolean flag =false;
		int length =a.length;
		int b[] = new int[length];

		for(int i=0; i<length; i++)
		{
			b[i]=i+1;
		}

		for(int i=0; i<length; i++)
		{
			if(a[i] != b[i])
			{
				int diff = a[i]-b[i];
				if(diff > 2)
				{
					flag= true;
					break;
				}
				else
				{
					bribes+=diff;
					int j=i+1;
					while(diff-- > 0)
					{
						b[j]=b[j]-1;
						j++;
					}
				}
			}
		}
		if(flag)
			System.out.println("Too chaotic");
		else
			System.out.println(bribes);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for(int a0 = 0; a0 < t; a0++){
			int n = in.nextInt();
			int[] q = new int[n];
			for(int q_i = 0; q_i < n; q_i++){
				q[q_i] = in.nextInt();
			}
			minimumBribes(q);
		}
		in.close();
	}

}
