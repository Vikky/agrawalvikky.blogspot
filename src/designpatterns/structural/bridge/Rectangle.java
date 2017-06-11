package designpatterns.structural.bridge;

/**
 * Created by viagrawal on 6/10/17.
 */
public class Rectangle extends Drawing
{

	Rectangle(Color color)
	{
		super(color);
	}

	@Override
	public void applyColor()
	{
		System.out.println("Drawing Rectangle");
		this.color.applyColor();
	}
}
