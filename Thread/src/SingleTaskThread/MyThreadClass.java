package SingleTaskThread;

class MyThread implements Runnable
{
	public void run()
	{
		task1();
		task2();
		task3();
	}
	
	public void task1()
	{
		System.out.println(" I am Task 1");
	}
	
	public void task2()
	{
		System.out.println(" I am Task 2");
	}
	
	public void task3()
	{
		System.out.println(" I am Task 3");
	}
}



public class MyThreadClass {

	public static void main(String[] args) throws InterruptedException {

       MyThread mt =new MyThread();
       Thread t = new Thread(mt);
       t.start();
       
	}

}
