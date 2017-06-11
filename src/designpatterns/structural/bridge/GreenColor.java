package designpatterns.structural.bridge;

/**
 * Created by viagrawal on 6/10/17.
 */
public class GreenColor implements Color
{
	@Override
	public void applyColor()
	{
		System.out.println("applied green color");
	}
}
