package designpatterns.behavioral.strategy;

import java.math.BigDecimal;

/**
 * Created by viagrawal on 6/11/17.
 */
public class CCPaymentStrategy implements PaymentStrategy
{
	@Override
	public void pay(BigDecimal amount)
	{
		System.out.println("Paid using credit card : " + amount);
	}
}
