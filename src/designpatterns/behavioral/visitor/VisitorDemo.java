package designpatterns.behavioral.visitor;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by viagrawal on 6/11/17.
 */
public class VisitorDemo
{
	public static void main(String[] args)
	{

		final ShoppingCartVisitor shoppingCartVisitor = new ShoppingCartVisitorImpl();
		final List<ItemElement> itemList =
				Arrays.asList(new BookItem("Effective Java", 100), new BookItem("Introduction to algorithms", 3000),
						new Mobile("One plus 5", 35000));
		System.out.println("Total cost of cart " + calculateTotalPrice(itemList, shoppingCartVisitor));
	}

	private static int calculateTotalPrice(final List<ItemElement> itemList,
			final ShoppingCartVisitor shoppingCartVisitor)
	{
		int totalCost = 0;
		final Iterator<ItemElement> iterator = itemList.iterator();
		while (iterator.hasNext())
		{
			totalCost += iterator.next().accept(shoppingCartVisitor);
		}
		return totalCost;
	}

}
