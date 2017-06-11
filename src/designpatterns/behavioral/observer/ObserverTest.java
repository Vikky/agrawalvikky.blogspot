package designpatterns.behavioral.observer;

/**
 * Created by viagrawal on 6/11/17.
 */

/**
 *  In the observer pattern, an object called the subject maintains a collection of objects called observers.
 *  When the subject changes, it notifies the observers. Observers can be added or removed from the collection
 *  of observers in the subject. The changes in state of the subject can be passed to the observers
 *  so that the observers can change their own state to reflect this change.
 */
public class ObserverTest
{
	public static void main(String[] args)
	{
		final WeatherStation weatherStation = new WeatherStation(38);
		final WeatherObserver observer1 = new WeatherConsumer1();
		final WeatherObserver observer2 = new WeatherConsumer2();

		weatherStation.addObserver(observer1);
		weatherStation.addObserver(observer2);

		weatherStation.setTemperature(42);

		weatherStation.removeObserver(observer2);
		weatherStation.setTemperature(40);
	}
}
