package designpatterns.creational.factory;

/**
 * Created by viagrawal on 6/10/17.
 */
public class Triangle implements Shape
{
	@Override
	public void draw(final String shape)
	{
		System.out.println("Drawing : "+shape);
	}
}
