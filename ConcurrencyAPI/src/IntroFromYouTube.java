// from https://www.youtube.com/watch?v=trzZwv9ja7Q&list=PL7Bt6mWpiizYve5v3_W5PQhDupA6a54Nw&index=2
public class IntroFromYouTube {

	public static void main(String[] args) {
		new IntroFromYouTube().doCounter();
	}
	
	private int count = 0;
	
	private synchronized void increment() {
		count++;
	}
	
	private void doCounter() {
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i = 0; i < 1_000_000; i++) {
					increment();
				}
				System.out.println(count);
				
			}
		});

		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i = 0; i < 1_000_000; i++) {
					increment();
				}
				System.out.println(count);
				
			}
		});
		
		t1.start();
		t2.start();
	}

}
