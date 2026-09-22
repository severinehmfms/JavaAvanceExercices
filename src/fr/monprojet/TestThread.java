package fr.monprojet;

public class TestThread extends Thread{

	public TestThread(String name) {
		super(name);
	}
	
	public void run() {
		for(int i = 0; i < 5; i++) {
			System.out.print(this.getName());	
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		//TestThread t = new TestThread("1-");
		//TestThread t2 = new TestThread("----B----");
		//t.start();
		//t2.start();
		
		//Thread 1
		/*TestThread t;
		for (int i = 0; i < 5; i++) {
	        t = new TestThread("1-" + i);
	        t.start();
	    }*/
		Thread t1 = new Thread(new TestThread("1-"));
		Thread t2 = new Thread(new TestThread("2-"));
		Thread t3 = new Thread(new TestThread("3-"));
		Thread t4 = new Thread(new TestThread("4-"));
		Thread t5 = new Thread(new TestThread("5-"));
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		
		
		/*Thread t1 = new Thread() {	//Classe anonyme
			public void run() {
				for(int i = 0; i < 5; i++) {
					System.out.print("1- ");			
				}
			}
		};
		t1.start();
		
		Thread t5 = new Thread() {
			public void run() {
				for(int i = 0; i < 4; i++) {
					System.out.print("5---- ");			
				}
			}
		};
		t5.start();*/
		
		
	}
	
}
