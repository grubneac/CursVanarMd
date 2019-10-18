
public class Intro {

	public static void main(String[] args) {
		Thread in1 = new Thread(new Incrementals("Thread 1"));
		Thread in2 = new Thread(new Incrementals("Thread 2"));
		
		in1.start();
		in2.start();
		

	}

}

class Incrementals implements Runnable {
	private static volatile int counter = 0;
	private String name;
//	private static Object monitor = new Object();
	
	public Incrementals(String name) {
		super();
		this.name = name;
	}

	@Override
	public void run() {
		for (int i = 0; i < 1_000_000; i++) {
			increment();			
		}
		System.out.println(name+" : "+counter);
	}
	
//	private void increment() {
//		synchronized (monitor) {
//			counter++;
//		}
//	}
	private synchronized void increment() {
			counter++;
	}
}
