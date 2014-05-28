/**
 * @author vikky.agrawal
 * 
 */
public class ThreadTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Semaphore s= new Semaphore();
		Producer p=new Producer(s);
		Consumer c= new Consumer(s,"first");
		//Consumer c1= new Consumer(s,"second");
		
		
		System.out.println("Main thread starts");
		
		p.start();
		c.start();
		//c1.start();
		
		try{
			p.join();
			//c.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally{
			System.out.println("Main thred stoppping");
		}
	}

}

class Producer extends Thread {

	Semaphore s;

	Producer(Semaphore s) {
		this.s = s;
	}

	@Override
	public void run() {

		for (int i = 0; i < 10; i++) {
			
			try{
				s.produce();
				Thread.sleep(1000);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			
			
		}
	}

}

class Consumer extends Thread {

	Semaphore s;
	String name;

	

	Consumer(Semaphore s,String name) {
		this.s = s;
		this.name=name;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			
			try{
				s.consume();
				Thread.sleep(1000);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}

	}

}

class Semaphore {

	int val = 0;
	private boolean available = false;

	public synchronized void consume() {
		try {
			while (!available) {
								
				wait();
				//System.out.println("consumer " + Thread.currentThread().getName());
			}
			val--;
			System.out.println("Consumed now value : " + val);
			available = false;
			notify();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public synchronized void produce() {
		try {
			while (available) {
				wait();
			}
			val++;
			System.out.println("Produced now value : " + val);
			available = true;
			notify();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
