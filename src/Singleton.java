import java.lang.reflect.Constructor;

/**
 * @author vikky.agrawal
 * @see http
 *      ://stackoverflow.com/questions/20421920/what-are-the-different-ways-we
 *      -can-break-a-singleton-pattern-in-java
 */

public class Singleton {

	private static Singleton single_instance;

	private Singleton() {
		// preventing reflection
		if (single_instance != null) {
			throw new IllegalStateException(
					"Singleton instance already created.");
		}
		System.out.println("Singleton constructor running");

	}

	public static Singleton getSingleton() {

		// double lock mechanism
		if (single_instance == null) {
			// if 1st thread is executing here then second thread checked above
			// condition hence both threads may exist here.
			synchronized (Singleton.class) {
				// prevent multiple threads from creating 2 instances.(2 phase
				// lock)
				if (single_instance == null)
					single_instance = new Singleton();
			}
		}
		return single_instance;
	}

	// preventing de-serialization
	protected Object readResolve() {
		return getSingleton();
	}

	// preventing cloning
	@Override
	public Object clone() throws CloneNotSupportedException {
		// return INSTANCE
		throw new CloneNotSupportedException();
	}

	public static void main(String args[]) throws Exception {
		// Breaking the singleton pact

		Singleton s = Singleton.getSingleton();

		Class clazz = Singleton.class;

		Constructor cons = clazz.getDeclaredConstructor();
		cons.setAccessible(true);

		Singleton s2 = (Singleton) cons.newInstance();
		System.out.println(s.hashCode());
		System.out.println(s2.hashCode());
	}

}

// using static class pattern

class BillPughSingleton {

	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;

	private BillPughSingleton() {
	}

	private static class LazyHolder {
		private static final BillPughSingleton INSTANCE = new BillPughSingleton();

	}

	public static BillPughSingleton getInstance() {
		return LazyHolder.INSTANCE;
	}

	protected Object readResolve() {
		return getInstance();
	}
}

// Using Enum

enum SingletonEnum {

	INSTANCE;

	public void distributePresents() {
		// elided
	}

	/** Demonstrate use of SantaClaus. */
	public static void main(String... aArgs) {
		SingletonEnum fatGuy = SingletonEnum.INSTANCE;
		fatGuy.distributePresents();

	}
}

// Using early instantiation -- static

class SingletonStatic {
	private static SingletonStatic instance = new SingletonStatic();

	private SingletonStatic() {
		System.out.println("Singleton(): Initializing Instance");
	}

	public static SingletonStatic getInstance() {
		return instance;
	}
}
