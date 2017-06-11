package designpatterns.behavioral.mediator;

/**
 * Created by viagrawal on 6/11/17.
 */
public class IndianBuyer extends Buyer
{
	public IndianBuyer(final Mediator mediator)
	{
		super(mediator, "INR");
		this.mediator.registerIndianBuyer(this);
	}
}
