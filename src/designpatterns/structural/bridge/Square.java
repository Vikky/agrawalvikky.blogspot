package designpatterns.structural.bridge;

/**
 * Created by viagrawal on 6/10/17.
 */
public class Square extends Drawing
{

	Square(Color color)
	{
		super(color);
	}

	@Override
	public void applyColor()
	{
		System.out.println("Drawing Square");
		this.color.applyColor();
	}
}
