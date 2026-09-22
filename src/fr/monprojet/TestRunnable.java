package fr.monprojet;

public class TestRunnable implements Runnable {

	@Override
	public void run() {
		for(int i = 0; i < 10; i++) {
			System.out.print((char) ('!' + i));
			//System.out.print((char) (33 + i));
			for (int j = 0; j <= i; j++) {				
		        System.out.print("*");
		    }
			System.out.print((char) ('!' + i));
			//System.out.print((char) (33 + i));
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		Thread thread = new Thread(new TestRunnable());
		thread.start();
	}
}
