package designpatterns.behavioral.observer;

/**
 * Created by viagrawal on 6/11/17.
 */
public interface WeatherSubject
{
	void addObserver(WeatherObserver weatherObserver);

	void removeObserver(WeatherObserver weatherObserver);

	void doNotify();

	int getUpdate();

}
