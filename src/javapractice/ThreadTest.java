package javapractice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author vikky.agrawal
 */
public class ThreadTest
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Semaphore s = new Semaphore();
		Producer p = new Producer(s);
		Consumer c = new Consumer(s, "first");
		//java.Consumer c1= new java.Consumer(s,"second");

		System.out.println("Main thread starts");

		//		p.start();
		//		c.start();
		//		c1.start();

		ExecutorService executorService = Executors.newFixedThreadPool(10);

		try
		{
			executorService.execute(p);
			executorService.execute(c);

			//			p.join();
			//			c.join();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{

			executorService.shutdown();

			System.out.println("Main thred stoppping");
		}



		//Testing deadlock

		DeadLockTest deadLockTest = new DeadLockTest();

		Thread t1 = new Thread(){

			@Override
			public void run()
			{
				deadLockTest.printHello();
			}
		};


		Thread t2 = new Thread(){

			@Override
			public void run()
			{
				deadLockTest.printBye();
			}
		};

		t1.start();
		t2.start();


	}

}

class Producer extends Thread
{

	Semaphore s;

	Producer(Semaphore s)
	{
		this.s = s;
	}

	@Override
	public void run()
	{

		for (int i = 0; i < Integer.MAX_VALUE; i++)
		{

			try
			{
				s.produce();
				Thread.sleep(1000);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}

		}
	}

}

class Consumer extends Thread
{

	Semaphore s;
	String name;

	Consumer(Semaphore s, String name)
	{
		this.s = s;
		this.name = name;
	}

	@Override
	public void run()
	{
		for (int i = 0; i < Integer.MAX_VALUE; i++)
		{

			try
			{
				s.consume();
				Thread.sleep(1000);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}

	}

}

class Semaphore
{

	int val = 0;
	private boolean available = false;

	public synchronized void consume()
	{
		try
		{
			while (!available)
			{

				wait();
				//System.out.println("consumer " + Thread.currentThread().getName());
			}
			val--;
			System.out.println("Consumed now value : " + val);
			available = false;
			notify();
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}

	public synchronized void produce()
	{
		try
		{
			while (available)
			{
				wait();
			}
			val++;
			System.out.println("Produced now value : " + val);
			available = true;
			notify();
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}

}


class DeadLockTest
{

	Object resource1 = new Object();
	Object resource2 = new Object();

	public void printHello()
	{

		synchronized (resource1)
		{
			System.out.println("Acquired resource1 lock");
			try
			{
				Thread.sleep(1000);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
			System.out.println("waiting for resource2 lock");
			synchronized (resource2)
			{
				System.out.println("Hello");
			}
		}
	}

	public void printBye()
	{
		synchronized (resource2)
		{
			System.out.println("Acquired resource2 lock");
			try
			{
				Thread.sleep(1000);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}

			System.out.println("waiting for resource1 lock");
			synchronized (resource1)
			{
				System.out.println("Bye");
			}
		}
	}

}

