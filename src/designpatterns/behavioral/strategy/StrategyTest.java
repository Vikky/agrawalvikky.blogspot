package designpatterns.behavioral.strategy;

import java.math.BigDecimal;

/**
 * Created by viagrawal on 6/11/17.
 */

/**
 * Strategy pattern is also known as Policy Pattern.
 * We define multiple algorithms and let client application pass
 * the algorithm to be used as a parameter.
 */
public class StrategyTest
{
	public static void main(String[] args)
	{
		final ShoppingCart shoppingCart = new ShoppingCart();

		final Item item1 = new Item("Jeans", new BigDecimal(1000));
		final Item item2 = new Item("Tshirt", new BigDecimal(100));

		shoppingCart.addItem(item1);
		shoppingCart.addItem(item2);

		shoppingCart.pay(new CCPaymentStrategy());
		shoppingCart.pay(new WalletPaymentStrategy());

	}

}
