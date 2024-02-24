package synchronized_;

public class Test {
	
	private static final Object lock = new Object(); 
	
	public static void print() {
		
		synchronized (lock) {
			for(int i=0; i<10; i++) {
				System.out.println(Thread.currentThread().getName() + " " + i);
			}	
		}	
	}

}
