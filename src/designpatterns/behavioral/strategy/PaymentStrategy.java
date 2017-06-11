package designpatterns.behavioral.strategy;

import java.math.BigDecimal;

/**
 * Created by viagrawal on 6/11/17.
 */
public interface PaymentStrategy
{
	void pay(BigDecimal amount);
}
