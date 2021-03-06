package javapractice;

import java.lang.reflect.Constructor;

/**
 * @author vikky.agrawal http://stackoverflow.com/questions/20421920/what-are-the-different-ways-we-can-break-a-singleton-pattern-in-java
 */

public class Singleton
{

	private volatile static Singleton single_instance;

	private Singleton()
	{
		// preventing reflection
		if (single_instance != null)
		{
			throw new IllegalStateException("java.Singleton instance already created.");
		}
		System.out.println("java.Singleton constructor running");

	}

	public static Singleton getSingleton()
	{

		// double lock mechanism
		if (single_instance == null)
		{
			// if 1st thread is executing here then second thread checked above
			// condition hence both threads may exist here.
			synchronized (Singleton.class)
			{
				// prevent multiple threads from creating 2 instances.(2 phase
				// lock)
				if (single_instance == null)
					single_instance = new Singleton();
			}
		}
		return single_instance;
	}

	// preventing de-serialization
	protected Object readResolve()
	{
		return getSingleton();
	}

	// preventing cloning
	@Override
	public Object clone() throws CloneNotSupportedException
	{
		// return INSTANCE
		throw new CloneNotSupportedException();
	}

	public static void main(String args[]) throws Exception
	{
		// Breaking the singleton pact

		Singleton s = Singleton.getSingleton();

		Class<Singleton> clazz = Singleton.class;

		Constructor<Singleton> cons = clazz.getDeclaredConstructor();
		cons.setAccessible(true);

		Singleton s2 = cons.newInstance();
		System.out.println(s.hashCode());
		System.out.println(s2.hashCode());
	}

}

// using static class pattern

class BillPughSingleton
{

	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;

	private BillPughSingleton()
	{
	}

	private static class LazyHolder
	{
		private static final BillPughSingleton INSTANCE = new BillPughSingleton();

	}

	public static BillPughSingleton getInstance()
	{
		return LazyHolder.INSTANCE;
	}

	protected Object readResolve()
	{
		return getInstance();
	}
}

// Using Enum

enum SingletonEnum
{

	INSTANCE;

	public void distributePresents()
	{
		System.out.println("Singleton instance");
	}

	/**
	 * Demonstrate use of SantaClaus.
	 */
	public static void main(String... aArgs)
	{
		SingletonEnum fatGuy = SingletonEnum.INSTANCE;
		fatGuy.distributePresents();

	}
}

// Using early instantiation -- static

class SingletonStatic
{
	private static SingletonStatic instance = new SingletonStatic();

	private SingletonStatic()
	{
		System.out.println("java.Singleton(): Initializing Instance");
	}

	public static SingletonStatic getInstance()
	{
		return instance;
	}
}
