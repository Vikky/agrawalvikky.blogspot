package designpatterns.structural.adapter;

/**
 * Created by viagrawal on 6/10/17.
 */
public class AdapterTest
{

	public static void main(String[] args)
	{
		final Socket socket = new Socket();
		final SocketAdapter socketAdapter = new SocketAdapterImpl(socket);
		System.out.println(socketAdapter.get120Volt());
		System.out.println(socketAdapter.get12Volt());
		System.out.println(socketAdapter.get4Volt());
	}

}
