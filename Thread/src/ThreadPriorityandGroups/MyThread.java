package ThreadPriorityandGroups;

class MyClass implements Runnable
{
	int count=0;
	
	public void run() {
		for(int i=1;i<3000;i++)
		     count++;
			
			System.out.println("Thread completed :"+Thread.currentThread().getName());
			System.out.println("Thread Priority :"+Thread.currentThread().getPriority());
			
	}			
}


public class MyThread {

	public static void main(String[] args) {

       MyClass mc = new MyClass();
       Thread t1 = new Thread(mc,"One");
       Thread t2 = new Thread(mc,"Two");
       
       t1.setPriority(2);
       t2.setPriority(Thread.NORM_PRIORITY);
       t1.start();
       t2.start();

	}

}
