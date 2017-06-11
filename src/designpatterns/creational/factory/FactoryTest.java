package designpatterns.creational.factory;

import static designpatterns.creational.factory.Shapes.CIRCLE;
import static designpatterns.creational.factory.Shapes.TRIANGLE;

/**
 * Created by vikky.agrawal on 6/10/17.
 * <p>
 * when to use factory pattern:
 * 1. Some or all concrete products can be created in multiple ways,
 * or we want to leave open the option that in the future there may be new ways to create the
 * concrete product.
 * <p>
 * 2. Factory method is used when Products don't need to know how they are created.
 */

/**
 * Advantages
 * E.g.: JDBC is a good example for this pattern;
 * application code doesn't need to know what database it will be used with,
 * so it doesn't know what database-specific driver classes it should use.
 * Instead, it uses factory methods to get Connections, Statements,
 * and other objects to work with. Which gives you flexibility to change your back-end database
 * without changing your DAO layer in case you are using ANSI SQL features and not coded on DBMS specific feature?
 * <p>
 * Another advantage of static factory method pattern is that they can cache frequently used object and eliminate duplicate object creation.
 * Boolean.valueOf() method is good example which caches true and false boolean value.
 */

public class FactoryTest
{

	public static void main(String[] args)
	{
		final Shape circle = ShapeFactory.createShape(CIRCLE);
		circle.draw(CIRCLE.getShape());

		final Shape triangle = ShapeFactory.createShape(TRIANGLE);
		triangle.draw(TRIANGLE.getShape());
	}

}

