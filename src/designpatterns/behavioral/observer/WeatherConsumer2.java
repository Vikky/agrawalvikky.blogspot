package designpatterns.behavioral.observer;

/**
 * Created by viagrawal on 6/11/17.
 */
public class WeatherConsumer2 implements WeatherObserver
{
	@Override
	public void doUpdate(final int temperature)
	{
		System.out.println("updated temp for customer 2 : " + temperature);
	}
}

