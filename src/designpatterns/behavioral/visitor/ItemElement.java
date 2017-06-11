package designpatterns.behavioral.visitor;

/**
 * Created by viagrawal on 6/11/17.
 */
public interface ItemElement
{
	int accept(ShoppingCartVisitor visitor);


}
