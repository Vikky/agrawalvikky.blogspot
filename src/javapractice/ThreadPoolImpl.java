package javapractice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by viagrawal on 30/07/18
 */
public class ThreadPoolImpl
{
	public static void main(String[] args)
	{

		ThreadPoolImpl threadPoolImpl = new ThreadPoolImpl(5);
		for (int i = 0; i < 500; i++)
		{
			threadPoolImpl.execute(new Worker(new Task("task :" + i)));
		}

	}

	private final int nThreads;
	private List<WorkerPool> threadPool;
	private BlockingQueue<Worker> blockingQueue;

	ThreadPoolImpl(int nThreads)
	{
		this.nThreads = nThreads;
		threadPool = new ArrayList<>(nThreads);
		this.blockingQueue = new LinkedBlockingQueue<>();

		for (int i = 0; i < nThreads; i++)
		{
			threadPool.add(new WorkerPool());
			threadPool.get(i).start();
		}

	}

	public void execute(Worker task)
	{
		synchronized (blockingQueue)
		{
			this.blockingQueue.add(task);
			blockingQueue.notify();
		}
	}

	private class WorkerPool extends Thread
	{
		@Override
		public void run()
		{
			Runnable task;

			while (true)
			{
				synchronized (blockingQueue)
				{
					while (blockingQueue.isEmpty())
					{
						try
						{
							blockingQueue.wait();
							System.out.println(
									"Thread :" + Thread.currentThread().getName() + " Waiting for queue to fill");
						}
						catch (InterruptedException e)
						{
							e.printStackTrace();
						}
					}
					task = blockingQueue.poll();
				}
				try
				{
					System.out.println(
							"Thread :" + Thread.currentThread().getName() + " will execute task " + ((Worker) task)
									.getTask().getTaskName());
					task.run();
					Thread.sleep(2);
				}
				catch (RuntimeException | InterruptedException e)
				{
					System.out.println("Thread pool is interrupted due to an issue: " + e.getMessage());
				}
			}
		}
	}
}

class Worker implements Runnable
{

	private Task task;

	Worker(Task task)
	{
		this.task = task;
	}

	@Override
	public void run()
	{
		System.out.println("Worker thread executing task " + task.getTaskName());

	}

	public Task getTask()
	{
		return task;
	}
}

class Task
{
	private String taskName;

	Task(String taskName)
	{
		this.taskName = taskName;
	}

	public String getTaskName()
	{
		return taskName;
	}
}