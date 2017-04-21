package greedy;

import java.util.Arrays;

/**
 * Job Sequencing Problem with Deadlines
 *
 * @author vikky.agrawal on 4/21/17.
 */
public class JobSequencing
{

	public static void main(String[] args)
	{
		Task[] activities = new Task[] { new Task(1, 9, 15), new Task(2, 2, 2), new Task(3, 5, 18), new Task(4, 7, 1),
				new Task(5, 4, 25), new Task(6, 2, 20), new Task(7, 5, 8), new Task(8, 7, 10), new Task(9, 4, 12),
				new Task(10, 3, 5), };
		findMaxProfit(activities);
	}

	private static void findMaxProfit(Task[] activities)
	{
		Arrays.sort(activities);
		Task[] selectedJobs = new Task[activities.length + 1];

		int profit = 0;
		for (Task job : activities)
		{
			int index = job.deadline;
			while (index > 0)
			{
				if (selectedJobs[index] == null)
				{
					selectedJobs[index] = job;
					profit += job.profit;
					break;
				}
				index--;
			}
			if (index == 0)
			{
				System.out.println("Job " + job + " Can't be picked");
			}
		}

		System.out.println("Max profit through job sequencing " + profit);
	}

	private static void printJobs(Task[] activities)
	{
		for (Task jobs : activities)
		{
			System.out.println(jobs);
		}
	}
}

class Task implements Comparable
{
	int taskid;
	int deadline;
	int profit;

	public Task(final int taskid, final int deadline, final int profit)
	{
		this.taskid = taskid;
		this.deadline = deadline;
		this.profit = profit;
	}

	/**
	 * Sorting based on max profit first
	 *
	 * @param object
	 * @return
	 */
	@Override
	public int compareTo(final Object object)
	{
		if (object instanceof Task)
		{
			return this.profit == ((Task) object).profit ? 0 : this.profit < ((Task) object).profit ? 1 : -1;
		}
		throw new ClassCastException("Not supported");
	}

	@Override
	public String toString()
	{
		return "Task{" +
				"taskid=" + taskid +
				", deadline=" + deadline +
				", profit=" + profit +
				'}';
	}
}

