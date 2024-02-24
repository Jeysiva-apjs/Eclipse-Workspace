package synchronized_;

public class Main {

	public static void main(String[] args) {
		
		Thread t1 = new Thread(()-> Test.print());
		Thread t2 = new Thread(()-> Test.print());
		
		t1.start();
		t2.start();
		
	}

}
