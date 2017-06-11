package designpatterns.structural.decorator;

/**
 * Created by viagrawal on 6/10/17.
 */
public abstract class AnimalDecorator implements Animal
{
	protected Animal animal;

	AnimalDecorator(final Animal animal)
	{
		this.animal = animal;
	}

}
