
public class TwoThreads {

	public static void main(String[] args) {
			new Incrementer().start();
			new Decrementer().start();
			new Printer().start();
	}

}
class Box {
	   public static Integer value = 0;
	}

	class Incrementer extends Thread{
	       public void increment(){
	             if (Box.value <3)
	             Box.value++;
	       }

		@Override
		public void run() {
			while(true) {
			increment();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}			}
		}
	       
	}
	class Decrementer extends Thread{
	       public void decrement(){
	             if(Box.value > -3)
	             Box.value--;
	       }
			@Override
			public void run() {
				while(true) {
				decrement();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}				}
			}
	}
	class Printer extends Thread{
	       public void print(){
	             if (Box.value>=0) System.out.println( Box.value );
	             else System.err.println(Box.value);
	       }
			@Override
			public void run() {
				while(true) {
				print();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				}
			}
	}