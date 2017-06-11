package designpatterns.behavioral.state;

/**
 * Created by viagrawal on 6/11/17.
 */
public class PersonContext
{
	private State state;

	public PersonContext(final State state)
	{
		this.state = state;
	}

	public void sayHello()
	{
		this.state.hello();
	}

	public void setState(final State state)
	{
		this.state = state;
	}
}
