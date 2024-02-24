package multi_threading;

public class TableThread implements Runnable{
	
	private int n;
	
	TableThread(int n) {
		this.n = n;
	}

	@Override
	public void run() {
		
		for(int i=1; i<=15; i++) {
			System.out.println(n + " * " + i + " = " + n*i);
		}		
	}
}
