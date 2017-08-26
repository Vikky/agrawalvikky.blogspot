package javapractice;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by viagrawal on 4/27/17.
 */
public class ProducerConsumer
{

	public static void main(String[] args)
	{
		Monitor monitor = new Monitor();
		Thread t1 = new Thread()
		{
			public void run()
			{
				for (int var = 0; var < 10; var++)
					monitor.produce();
			}
		};

		Thread t2 = new Thread()
		{
			public void run()
			{
				for (int var = 0; var < 10; var++)
					monitor.consume();
			}
		};

		t1.start();
		t2.start();
	}

}

class Monitor
{

	private int value = 0;
	final BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(1);

	public void produce()
	{
		try
		{
			value++;
			blockingQueue.put(value);
			System.out.println("produced " + value);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}

	public void consume()
	{
		try
		{
			int peek = blockingQueue.take();
			System.out.println("consumed " + peek);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}
}

