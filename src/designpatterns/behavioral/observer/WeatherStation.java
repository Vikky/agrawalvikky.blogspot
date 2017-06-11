package designpatterns.behavioral.observer;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by viagrawal on 6/11/17.
 */
public class WeatherStation implements WeatherSubject
{

	final Set<WeatherObserver> weatherObservers;
	private int temperature;

	public WeatherStation(int temperature)
	{
		weatherObservers = new HashSet<>();
		this.temperature = temperature;
	}

	@Override
	public void addObserver(final WeatherObserver weatherObserver)
	{
		weatherObservers.add(weatherObserver);
	}

	@Override
	public void removeObserver(final WeatherObserver weatherObserver)
	{
		weatherObservers.remove(weatherObserver);
	}

	@Override
	public void doNotify()
	{
		weatherObservers.stream().forEach(weatherObserver -> weatherObserver.doUpdate(temperature));
	}

	@Override
	public int getUpdate()
	{
		return this.temperature;
	}

	public void setTemperature(int newTemperature)
	{
		System.out.println("\nWeather station setting temperature to " + newTemperature);
		temperature = newTemperature;
		doNotify();
	}

}
