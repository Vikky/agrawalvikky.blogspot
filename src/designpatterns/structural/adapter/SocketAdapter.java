package designpatterns.structural.adapter;

/**
 * Created by viagrawal on 6/10/17.
 */
public interface SocketAdapter
{
	Volt get120Volt();
	Volt get12Volt();
	Volt get4Volt();
}
