package javapractice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by viagrawal on 30/07/18
 */
public class ProducerConsumerImpl
{
	public static void main(String[] args)
	{
		ExecutorService executorService = Executors.newFixedThreadPool(5);

		Resource resource = new Resource();
		Producers producers = new Producers(resource);
		Consumers consumers = new Consumers(resource);

		executorService.execute(producers);
		executorService.execute(consumers);

		executorService.shutdown();
	}
}

class Resource
{
	private int counter;

	public int getCounter()
	{
		return counter;
	}

	public void setCounter(final int counter)
	{
		this.counter = counter;
	}
}

class Producers implements Runnable
{

	private Resource resource;

	Producers(Resource resource)
	{
		this.resource = resource;
	}

	@Override
	public void run()
	{

		for (int i = 0; i < 10; i++)
		{
			synchronized (resource)
			{
				resource.setCounter(resource.getCounter() + 1);
				System.out.println("Produced " + resource.getCounter());
			}
			try
			{
				Thread.sleep(3);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}

	}
}

class Consumers implements Runnable
{

	private Resource resource;

	Consumers(Resource resource)
	{
		this.resource = resource;
	}

	@Override
	public void run()
	{

		for (int i = 0; i < 10; i++)
		{
			synchronized (resource)
			{
				resource.setCounter(resource.getCounter() - 1);
				System.out.println("Consumed " + resource.getCounter());
			}
			try
			{
				Thread.sleep(10);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}
}



