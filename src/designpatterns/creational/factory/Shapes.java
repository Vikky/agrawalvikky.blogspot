package designpatterns.creational.factory;

/**
 * Created by viagrawal on 6/10/17.
 */
public enum Shapes
{
	CIRCLE("circle"),
	TRIANGLE("trianlge");

	private String shape;

	Shapes(final String shape)
	{
		this.shape = shape;
	}

	public String getShape()
	{
		return shape;
	}
}
