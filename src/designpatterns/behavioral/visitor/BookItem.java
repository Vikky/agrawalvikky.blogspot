package designpatterns.behavioral.visitor;

/**
 * Created by viagrawal on 6/11/17.
 */
public class BookItem implements ItemElement
{
	private String bookName;
	private int bookPrice;

	public BookItem(final String bookName, final int bookPrice)
	{
		this.bookName = bookName;
		this.bookPrice = bookPrice;
	}

	@Override
	public int accept(final ShoppingCartVisitor visitor)
	{
		return visitor.visit(this);
	}

	public String getBookName()
	{
		return bookName;
	}

	public void setBookName(final String bookName)
	{
		this.bookName = bookName;
	}

	public int getBookPrice()
	{
		return bookPrice;
	}

	public void setBookPrice(final int bookPrice)
	{
		this.bookPrice = bookPrice;
	}

	@Override
	public String toString()
	{
		return "BookItem{" +
				"bookName='" + bookName + '\'' +
				", bookPrice=" + bookPrice +
				'}';
	}
}
