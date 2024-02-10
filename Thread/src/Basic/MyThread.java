package Basic;

public class MyThread {

	public static void main(String[] args) {
   
		Thread t = Thread.currentThread();
		System.out.println("Current Thread ="+t);
		System.out.println("Name = "+t.getName());
 
	}

}
