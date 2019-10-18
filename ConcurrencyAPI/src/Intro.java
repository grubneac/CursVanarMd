
public class Intro {
	static int counter = 0;
	
	static synchronized void increment() {
		counter++;
	}

	public static void main(String[] args) {

		Thread in1 = new Thread(new Incrementals("Thread 1"));
		Thread in2 = new Thread(new Incrementals("Thread 2"));
		
		in1.start();
		in2.start();
		

	}

}

class Incrementals implements Runnable {
	private String name;
//	private static Object monitor = new Object();
	
	public Incrementals(String name) {
		super();
		this.name = name;
	}

	@Override
	public void run() {
		for (int i = 0; i < 1_000_000; i++) {
			Intro.increment();			
		}
		System.out.println(name+" : "+Intro.counter);
	}
	
//	private void increment() {
//		synchronized (monitor) {
//			counter++;
//		}
//	}

}
