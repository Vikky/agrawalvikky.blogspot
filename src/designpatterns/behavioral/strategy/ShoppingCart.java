package designpatterns.behavioral.strategy;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by viagrawal on 6/11/17.
 */
public class ShoppingCart
{
	final List<Item> itemList;

	public ShoppingCart()
	{
		this.itemList = new ArrayList<>();
	}

	public void addItem(final Item item)
	{
		this.itemList.add(item);
	}

	private BigDecimal calculateCartTotal()
	{
		BigDecimal totalAmount = new BigDecimal(0);
		final Iterator<Item> itemIterator = itemList.iterator();
		while (itemIterator.hasNext())
		{
			totalAmount = totalAmount.add(itemIterator.next().getAmount());
		}
		return totalAmount;
	}

	public void pay(final PaymentStrategy paymentStrategy)
	{
		paymentStrategy.pay(calculateCartTotal());
	}

}
