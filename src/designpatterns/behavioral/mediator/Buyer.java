package designpatterns.behavioral.mediator;

/**
 * Created by viagrawal on 6/11/17.
 */
public class Buyer
{
	protected Mediator mediator;
	private String currency;

	public Buyer(final Mediator mediator, final String currency)
	{
		this.mediator = mediator;
		this.currency = currency;
	}

	public boolean attemptToBuy(final float bid, final String unitOfCurrency)
	{
		System.out.println("Buyer attempting a bid of " + bid + " " + unitOfCurrency);
		return mediator.placeBid(bid, unitOfCurrency);
	}

}
