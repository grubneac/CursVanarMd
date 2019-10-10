import java.util.Random;

public class ThreadedApp {

	public static void main(String[] args) {
		new RandomThread().start();;
		printRandom("Second");
	}
	
	public static void printRandom(String pefix) {
		Random rnd =new Random();
		while(true) {
			System.out.println(pefix+": "+rnd.nextInt(100));
		}
	}
}

class RandomThread extends Thread{

	@Override
	public void run() {
		ThreadedApp.printRandom("First");
	}
	
}