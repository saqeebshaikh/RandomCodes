import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Main {
	private static volatile Integer counter = 1;
	
	public static void main(String[] args) {
		System.out.println("Main starts!");
		Main mainObj = new Main();
		Thread evenThread = new Thread(mainObj.new EvenThread(mainObj), "EvenThread");
		Thread oddThread  = new Thread(mainObj.new OddThread(mainObj), "OddThread");
		oddThread.start();
		evenThread.start();
		System.out.println("Main ends!");
	}
	
	private class EvenThread implements Runnable {
		private Main mainObj;
		public EvenThread(Main mainObj) {
			this.mainObj = mainObj;
		}
		
		@Override
		public void run() {
			try {
				synchronized (mainObj) {
					while(counter <= 10 ) {
						if(counter % 2 == 0) {
							System.out.println(Thread.currentThread().getName()+" prints :: "+mainObj.counter++);
							mainObj.notifyAll();
							Thread.sleep(1000);
						} else {
							System.out.println(Thread.currentThread().getName()+" invokes waits!");
							mainObj.wait();
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	private class OddThread implements Runnable {
		private Main mainObj;
		public OddThread(Main mainObj) {
			this.mainObj = mainObj;
		}
		
		@Override
		public void run() {
			try {
				synchronized (mainObj) {
					while(counter <= 10 ) {
						if(counter % 2 == 1) {
							System.out.println(Thread.currentThread().getName()+" prints :: "+mainObj.counter++);
							mainObj.notifyAll();
							Thread.sleep(1000);
						} else {
							System.out.println(Thread.currentThread().getName()+" invokes waits!");
							mainObj.wait();
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
