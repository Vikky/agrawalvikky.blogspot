package designpatterns.behavioral.state;

/**
 * Created by viagrawal on 6/11/17.
 */
public class StateDemo
{
	public static void main(String[] args)
	{
		final State happyState = new HappyState();
		final State sadState = new SadState();

		final PersonContext personContext = new PersonContext(happyState);
		personContext.sayHello();

		personContext.setState(sadState);
		personContext.sayHello();

		personContext.setState(happyState);
		personContext.sayHello();
	}

}
