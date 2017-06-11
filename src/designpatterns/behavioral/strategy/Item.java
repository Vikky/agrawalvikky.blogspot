package designpatterns.behavioral.strategy;

import java.math.BigDecimal;

/**
 * Created by viagrawal on 6/11/17.
 */
public class Item
{
	private String itemType;
	private BigDecimal amount;

	public Item(final String itemType, final BigDecimal amount)
	{
		this.itemType = itemType;
		this.amount = amount;
	}

	public String getItemType()
	{
		return itemType;
	}

	public void setItemType(final String itemType)
	{
		this.itemType = itemType;
	}

	public BigDecimal getAmount()
	{
		return amount;
	}

	public void setAmount(final BigDecimal amount)
	{
		this.amount = amount;
	}

	@Override
	public String toString()
	{
		return "Item{" +
				"itemType='" + itemType + '\'' +
				", amount=" + amount +
				'}';
	}
}
