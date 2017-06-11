package designpatterns.structural.adapter;

/**
 * Created by viagrawal on 6/10/17.
 */
public class Socket
{
	/**
	 * Socket only produces 120 volts
	 * @return
	 */
	public Volt getVolt(){
		return new Volt(120);
	}
}
