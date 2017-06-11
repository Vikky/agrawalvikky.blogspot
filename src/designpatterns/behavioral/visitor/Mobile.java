package designpatterns.behavioral.visitor;

/**
 * Created by viagrawal on 6/11/17.
 */
public class Mobile implements ItemElement
{
	private String mobileName;
	private int mobilePrice;

	public Mobile(final String mobileName, final int mobilePrice)
	{
		this.mobileName = mobileName;
		this.mobilePrice = mobilePrice;
	}

	@Override
	public int accept(final ShoppingCartVisitor visitor)
	{
		return visitor.visit(this);
	}

	public String getMobileName()
	{
		return mobileName;
	}

	public void setMobileName(final String mobileName)
	{
		this.mobileName = mobileName;
	}

	public int getMobilePrice()
	{
		return mobilePrice;
	}

	public void setMobilePrice(final int mobilePrice)
	{
		this.mobilePrice = mobilePrice;
	}

	@Override
	public String toString()
	{
		return "Mobile{" +
				"mobileName='" + mobileName + '\'' +
				", mobilePrice=" + mobilePrice +
				'}';
	}
}
