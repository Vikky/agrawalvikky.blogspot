package greedy;

import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * You are given n activities with their start and finish times. Select the maximum number of activities that can
 * be performed by a single person, assuming that a person can only work on a single activity at a time.
 * <p>
 * Solution : Assuming Finish times are sorted.
 * <p>
 * Created by vikky.agrawal on 4/18/17.
 */
public class ActivitySelection
{

	public static void main(String[] args)
	{
		Activity[] activities =
				new Activity[] { new Activity(1, 4), new Activity(3, 5), new Activity(0, 6), new Activity(5, 7),
						new Activity(3, 8), new Activity(5, 9), new Activity(6, 10), new Activity(8, 11),
						new Activity(8, 12), new Activity(2, 13), new Activity(12, 14) };

		chooseMaxActivities(activities);
	}

	private static void chooseMaxActivities(Activity[] activities)
	{
		Queue<Activity> queue = new PriorityQueue<>();
		Activity latestActivity = activities[0];
		queue.add(latestActivity);

		for (int i = 1; i < activities.length; i++)
		{
			if (activities[i].start >= latestActivity.finish)
			{
				latestActivity = activities[i];
				queue.add(latestActivity);
			}
		}

		Iterator<Activity> iterator = queue.iterator();
		while (iterator.hasNext())
		{
			System.out.println(iterator.next());
		}
	}

}

class Activity implements Comparable
{
	int start;
	int finish;

	public Activity(final int start, final int finish)
	{
		this.start = start;
		this.finish = finish;
	}

	@Override
	public int compareTo(final Object obj)
	{
		if (obj instanceof Activity)
		{
			return (this.finish == ((Activity) obj).finish) ? 0 : this.finish > ((Activity) obj).finish ? 1 : -1;
		}
		throw new ClassCastException();
	}

	@Override
	public String toString()
	{
		return "Activity{" +
				"start=" + start +
				", finish=" + finish +
				'}';
	}
}