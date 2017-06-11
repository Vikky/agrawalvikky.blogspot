package designpatterns.behavioral.visitor;

/**
 * Created by viagrawal on 6/11/17.
 */
public class ShoppingCartVisitorImpl implements ShoppingCartVisitor
{

	//Cost calculation logic at a single place using visitor
	@Override
	public int visit(final BookItem bookItem)
	{

		int cost = bookItem.getBookPrice();
		//apply 5 Rupees discount if book price is greater than 50
		if (bookItem.getBookPrice() > 50)
		{
			cost = bookItem.getBookPrice() - 5;
		}
		System.out.println("Book :: " + bookItem.getBookName() + " | Book cost :: " + cost);
		return cost;

	}

	@Override
	public int visit(final Mobile mobile)
	{
		System.out.println("Mobile :: " + mobile.getMobileName() + " | Mobile price :: " + mobile.getMobilePrice());
		return mobile.getMobilePrice();
	}

}
