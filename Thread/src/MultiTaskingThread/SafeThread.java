package MultiTaskingThread;

class Tickets implements Runnable
{
	int avail=1;
	int want;
	
	Tickets(int avail,int want)
	{
		this.avail=avail;
		this.want=want;
	}
	
	//you have choice either use synchronized keyword or block 
	synchronized public void run()
	{
	//public void run()
	//{
		synchronized (this) {
			//dispaly all Tickets available
			System.out.println("No of Tickets :"+avail);
			
			if(avail>=want)
			{
				//get the name of Passenger 
				String name = Thread.currentThread().getName();
				//which passenger will get ticket
				System.out.println(want+" Ticket booked for"+name);
				
				try
				{
					Thread.sleep(1500);         //wait for ticket to print
					avail=avail-1;              //finally update available tickets
					System.out.println("Updated No of Tickets : "+avail);
				}catch(InterruptedException e)
				{
					e.printStackTrace();
				}
			}else
			{
				System.out.println("Sorry!!!!!! Tickets are not available");
			}
		}
		
	}
}


public class SafeThread {

	public static void main(String[] args) {

   Tickets t =new Tickets(10,1);                 
   
   Thread t1 = new Thread(t);        
   Thread t2 = new Thread(t);
   
   t1.setName("First Passenger");
   t2.setName("Second Passenger");

 t1.start();
 t2.start();
	}

}
