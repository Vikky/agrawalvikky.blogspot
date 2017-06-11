package designpatterns.behavioral.mediator;

/**
 * Created by viagrawal on 6/11/17.
 */
public class AmericanBuyer extends Buyer
{
	public AmericanBuyer(final Mediator mediator)
	{
		super(mediator, "USD");
		mediator.registerAmericanBuyer(this);
	}
}
