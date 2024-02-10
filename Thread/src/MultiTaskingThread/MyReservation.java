// when more than one thread is acting on same object simultaneosly (unsafe) Thread

package MultiTaskingThread;

class Reserve implements Runnable
{
	int available=1;
	int wanted;
	
	Reserve(int i)
	{
		this.wanted =i;
	}
	
	public void run()
	{
		

			//dispaly all available birth
			System.out.println("All available birth : "+available);
			
			if(available>=wanted)
			{
				//get the name of threads
				String name = Thread.currentThread().getName();
				//book ticket for passenger
				System.out.println(wanted +" Berth for passenger"+name);
				
				try
				{
					Thread.sleep(1500);      // wait to print ticket
					available=available-1; //finally update the available birth
				}catch(InterruptedException e)
				{
					e.printStackTrace();
				}
			}else
			{
				System.out.println("Sorry!!!!! Births are not available");
			}
		
	}
}

public class MyReservation {

	public static void main(String[] args) {

 Reserve r = new Reserve(1);
 Thread t1= new Thread(r);
 Thread t2 = new Thread(r);
 
 t1.setName("First Passenger");
 t2.setName("Second Passenger");

 t1.start();
 t2.start();

	}

}
