package designpatterns.structural.decorator;

/**
 * Created by viagrawal on 6/10/17.
 */
public class DecoratorTest
{
	public static void main(String[] args)
	{
		Animal animal = new AnimalBase();
		animal.describe();

		//Adding functionality at runtime
		animal = new LegDecorator(animal);
		animal.describe();

		animal = new WingDecorator(animal);
		animal.describe();

		Animal decorated = new WingDecorator(new LegDecorator(new AnimalBase()));
		decorated.describe();

	}

}
