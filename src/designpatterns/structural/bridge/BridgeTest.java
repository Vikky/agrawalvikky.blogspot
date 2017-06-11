package designpatterns.structural.bridge;

/**
 * Created by viagrawal on 6/10/17.
 */

//The abstraction contains a reference(bridge) to the implementor
public class BridgeTest
{

	public static void main(String[] args)
	{
		Drawing rectangle = new Rectangle(new RedColor());
		rectangle.applyColor();

		rectangle = new Rectangle(new GreenColor());
		rectangle.applyColor();

		Drawing square = new Square(new RedColor());
		square.applyColor();

		square = new Square(new GreenColor());
		square.applyColor();

	}

}
