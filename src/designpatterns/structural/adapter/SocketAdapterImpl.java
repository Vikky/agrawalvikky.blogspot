package designpatterns.structural.adapter;

/**
 * Created by viagrawal on 6/10/17.
 */
public class SocketAdapterImpl implements SocketAdapter
{
	private Socket socket;

	SocketAdapterImpl(final Socket socket)
	{
		this.socket = socket;
	}

	@Override
	public Volt get120Volt()
	{
		return socket.getVolt();
	}

	/**
	 * Adapter converts the voltage
	 * @return
	 */
	@Override
	public Volt get12Volt()
	{
		Volt volt = socket.getVolt();
		return convertVoltage(volt, 10);
	}

	@Override
	public Volt get4Volt()
	{
		Volt volt = socket.getVolt();
		return convertVoltage(volt, 30);
	}

	private Volt convertVoltage(Volt volt, Integer voltage)
	{
		return new Volt(volt.getVoltage() / voltage);
	}
}
