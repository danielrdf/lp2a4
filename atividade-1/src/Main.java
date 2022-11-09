
public class Main {

	public static void main(String[] args) {

		MinhaThread thread1 = new MinhaThread("Thread #1", 600);
		MinhaThread thread2 = new MinhaThread("Thread #2", 1000);
		MinhaThread thread3 = new MinhaThread("Thread #3", 200);

		Thread t1 = new Thread(thread1);
		Thread t2 = new Thread(thread2);
		Thread t3 = new Thread(thread3);

		t1.start();
		t2.start();
		t3.start();

		try {
			t1.join();
			t2.join();
			t3.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Programa finalizado");

	}

}
