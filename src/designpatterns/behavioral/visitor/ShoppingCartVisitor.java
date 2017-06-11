package designpatterns.behavioral.visitor;

/**
 * Created by viagrawal on 6/11/17.
 */
public interface ShoppingCartVisitor
{
	int visit(BookItem bookItem);

	int visit(Mobile mobile);
}
