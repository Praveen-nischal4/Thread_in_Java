package MultiTaskingThread;

class Cinema implements Runnable
{
	private String str;
	
	Cinema(String str)
	{
		this.str =str;
	}
	public void run()
	{
		for(int i=1;i<=20;i++)
		{
			System.out.println(str +" "+i);
			
			try
			{
				Thread.sleep(2000);
			}catch(InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	
}

public class DemoCinema {

	public static void main(String[] args) {
		 
		Cinema c = new Cinema("Cut the ticket");
		Cinema c2 = new Cinema("Show the seat");
		
		Thread t1 = new Thread(c);
		Thread t2 = new Thread(c2);
		
		t1.start();
		t2.start();

	}

}
