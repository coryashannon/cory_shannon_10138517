
public class SimpleThread implements Runnable {

	Resource resource;

	public void run() {
		for (int i = 0; i < 100; i++) {
			try {
				System.out.println(resource.increment());
				Thread.sleep(1);

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	SimpleThread(Resource resource) {
		this.resource = resource;
	}

	public static void main(String args[]) {
		Resource resource = new Resource();

		Runnable t = new SimpleThread(resource);
		Runnable s = new SimpleThread(resource);

		Thread t1 = new Thread(t);
		Thread s1 = new Thread(s);

		t1.start();
		s1.start();

		try {
			t1.join();
			s1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
