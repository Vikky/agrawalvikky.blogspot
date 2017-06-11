package designpatterns.structural.decorator;

/**
 * Created by viagrawal on 6/10/17.
 */
public class WingDecorator extends AnimalDecorator
{

	public WingDecorator(final Animal animal)
	{
		super(animal);
	}

	@Override
	public void describe()
	{
		animal.describe();
		System.out.println("I have wings");
		fly();
	}

	private void fly()
	{
		System.out.println("I can fly");
	}
}
