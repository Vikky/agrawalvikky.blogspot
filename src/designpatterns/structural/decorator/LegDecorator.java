package designpatterns.structural.decorator;

/**
 * Created by viagrawal on 6/10/17.
 */
public class LegDecorator extends AnimalDecorator
{

	public LegDecorator(Animal animal)
	{
		super(animal);
	}

	@Override
	public void describe()
	{
		animal.describe();
		System.out.println("I have legs.");
		dance();
	}

	public void dance()
	{
		System.out.println("I can dance.");
	}

}
