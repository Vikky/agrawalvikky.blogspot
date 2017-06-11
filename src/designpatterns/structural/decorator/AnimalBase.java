package designpatterns.structural.decorator;

/**
 * Created by viagrawal on 6/10/17.
 */
public class AnimalBase implements Animal
{
	@Override
	public void describe()
	{
		System.out.println("I am basic animal");
	}
}
