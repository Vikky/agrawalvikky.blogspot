package designpatterns.behavioral.strategy;

import java.math.BigDecimal;

/**
 * Created by viagrawal on 6/11/17.
 */
public class WalletPaymentStrategy implements PaymentStrategy
{
	@Override
	public void pay(final BigDecimal amount)
	{
		System.out.println("Payment done using wallet : " + amount);
	}
}
