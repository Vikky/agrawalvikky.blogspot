package designpatterns.behavioral.mediator;

/**
 * Created by viagrawal on 6/11/17.
 */
public class Mediator
{
	Buyer indianBuyer;
	Buyer americanBuyer;

	AmericanSeller americanSeller;

	public void registerIndianBuyer(IndianBuyer indianBuyer)
	{
		this.indianBuyer = indianBuyer;
	}

	public void registerAmericanBuyer(AmericanBuyer americanBuyer)
	{
		this.americanBuyer = americanBuyer;
	}

	public void registerAmericanSeller(AmericanSeller americanSeller)
	{
		this.americanSeller = americanSeller;
	}

	public boolean placeBid(final float bid, final String unitOfCurrency)
	{
		float dollarAmount = convertCurrencyToDollars(bid, unitOfCurrency);
		return americanSeller.acceptBid(dollarAmount);
	}

	private float convertCurrencyToDollars(final float bid, final String unitOfCurrency)
	{
		switch (unitOfCurrency)
		{
		case "INR":
			return bid / 65;
		case "USD":
			return bid * 65;
		default:
			throw new UnsupportedOperationException(unitOfCurrency + " not supported");
		}
	}

}
