package designpatterns.behavioral.state;

/**
 * Created by viagrawal on 6/11/17.
 */
public class HappyState implements State
{
	@Override
	public void hello()
	{
		System.out.println("Hello. I am happy");
	}
}
