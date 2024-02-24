package multi_threading;

public class TableMain {

	public static void main(String[] args) throws InterruptedException {
		
		SampleThread t = new SampleThread();
		Thread thread = new Thread(t, "Sample Thread");
		thread.setDaemon(true);
		thread.start();
		
		TableThread t1 = new TableThread(5);
		Thread thread1 = new Thread(t1, "Table of 5");
		System.out.println("Thread name: " + thread1.getName());
		thread1.start();
		
		TableThread t2 = new TableThread(7);
		Thread thread2 = new Thread(t2, "Table of 7");
		System.out.println("Thread name: " + thread2.getName());
		thread2.start();

	}

}
