package designpatterns.behavioral.mediator;

/**
 * Created by viagrawal on 6/11/17.
 */
public class MediatorTest
{
	public static void main(String[] args)
	{
		final Mediator mediator = new Mediator();
		final Buyer indianBuyer = new IndianBuyer(mediator);
		final Buyer americanBuyer = new AmericanBuyer(mediator);

		float sellingPriceInDollars = 10.0f;
		AmericanSeller americanSeller = new AmericanSeller(mediator);


		float indianBidInRupees = 800f;
		while (!indianBuyer.attemptToBuy(indianBidInRupees, "INR")) {
			indianBidInRupees += 50f;
		}

	}

}
