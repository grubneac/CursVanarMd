
public class JoinThreadExample {

	public static void main(String[] args) throws InterruptedException {
		Thread th1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName());
				
			}
		});
		Thread th2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName());
				
			}
		});
		
		th1.start();
		th2.start();
		
		th1.join();
		
		System.out.println("End main Thread");

	}

}
