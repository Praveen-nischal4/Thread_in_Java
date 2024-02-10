package Deadlocks;

class BookTicket implements Runnable
{
	Object train,comp;
	
	BookTicket(Object train,Object comp)
	{
		this.train=train;
		this.comp=comp;
	}
	
	public void run()
	{
		synchronized (train) {
			
			System.out.println("BookTicket locked on Train ");
			
			try
			{
				Thread.sleep(150);				
			}catch(InterruptedException e)
			{
				e.printStackTrace();
			}
			
			System.out.println("BookTicket is now waiting to locked on Comparment");
			
			synchronized (comp) {
				System.out.println("Book ticket is now locked in compartment");
			}
			
			
		}
	}
}


class CancelTicket implements Runnable
{
	Object train,comp;
	
	CancelTicket(Object train,Object comp)
	{
		this.train =train;
		this.comp=comp;
	}
	
	public void run()
	{
		synchronized (comp) {
			 System.out.println("CancelTicket is locked on Comprtment");
			 try
			 {
				 Thread.sleep(200);
			 }catch(InterruptedException f)
			 {
				 f.printStackTrace();
			 }
			 
			 System.out.println("CancelTicket is now waiting to locked on train");
			 
			 synchronized (train) {
			  System.out.println("CancelTicket is now locked on Train");	
			}
		}
	}
}


public class Deadlock {

	public static void main(String[] args) {

		Object train = new Object();
		Object comp = new Object();
		
		BookTicket obj1 = new BookTicket(train,comp);
		CancelTicket obj2 = new CancelTicket(train,comp);
		
		Thread t1 = new Thread(obj1);
		Thread t2 = new Thread(obj2);
		t1.start();
		t2.start();
  
	}

}
