package javapractice;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by viagrawal on 8/26/17.
 */
public class CyclicBarrierTest
{

	public static void main(String[] args)
	{

		final CyclicBarrier cyclicBarrier =
				new CyclicBarrier(4, () -> System.out.println("All ready to run &  Running parallel"));
		final Runner runner1 = new Runner("BMW", cyclicBarrier);
		final Runner runner2 = new Runner("MRCDZ", cyclicBarrier);
		final Runner runner3 = new Runner("AUDI", cyclicBarrier);
		final Runner runner4 = new Runner("JAGUAR", cyclicBarrier);

		runner1.start();
		runner2.start();
		runner3.start();
		runner4.start();

	}

}

class Runner extends Thread
{
	private CyclicBarrier barrier;

	public Runner(final String name, final CyclicBarrier barrier)
	{
		super(name);
		this.barrier = barrier;
	}

	@Override
	public void run()
	{
		try
		{
			System.out.println(this.getName() + " ready to start, waiting for others");
			barrier.await();
			System.out.println(this.getName() + " running");
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		catch (BrokenBarrierException e)
		{
			e.printStackTrace();
		}
	}
}
