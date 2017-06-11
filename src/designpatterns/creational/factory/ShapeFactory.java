package designpatterns.creational.factory;

/**
 * Created by viagrawal on 6/10/17.
 */
public class ShapeFactory
{
	public static Shape createShape(final Shapes shape)
	{
		switch (shape)
		{
		case CIRCLE:
			return new Circle();
		case TRIANGLE:
			return new Triangle();
		default:
			return new Circle();
		}
	}

}
