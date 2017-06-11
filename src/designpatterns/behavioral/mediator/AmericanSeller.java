package designpatterns.behavioral.mediator;

/**
 * Created by viagrawal on 6/11/17.
 */
public class AmericanSeller
{
	private Mediator mediator;

	public AmericanSeller(Mediator mediator)
	{
		this.mediator = mediator;
		this.mediator.registerAmericanSeller(this);
	}

	public boolean acceptBid(final float bid)
	{
		if (bid > 20)
			return true;
		return false;
	}

}
