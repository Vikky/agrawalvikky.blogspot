package designpatterns.structural.adapter;

/**
 * Created by viagrawal on 6/10/17.
 */
public class Volt
{
	private Integer voltage;

	public Volt(final Integer voltage)
	{
		this.voltage = voltage;
	}

	public Integer getVoltage()
	{
		return voltage;
	}

	public void setVoltage(final Integer voltage)
	{
		this.voltage = voltage;
	}

	@Override
	public String toString()
	{
		return "Volt{" +
				"voltage=" + voltage +
				'}';
	}
}
