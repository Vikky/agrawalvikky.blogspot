package designpatterns.structural.bridge;

/**
 * Created by viagrawal on 6/10/17.
 */

//The abstraction contains a reference to the implementor
public abstract class Drawing
{

	//This creates a bridge with color
	protected Color color;

	Drawing(Color color)
	{
		this.color =color;
	}

	public abstract void applyColor();


}
