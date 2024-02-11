package Problem;

public class Communicate {

	public static void main(String[] args) {
     
		Producer obj1 = new Producer();
		Consumer obj2 = new Consumer(obj1);
		
		Thread t1 = new Thread(obj1);
		Thread t2 = new Thread(obj2);
		
          t2.start();
          t1.start();

	}

}


class Producer extends Thread
{
	StringBuffer sb;       // reference of String buffer 
	
	boolean dataprodover =false; // boolean variable toc heck dataproduction is over or not
	
	Producer()
	{
		sb= new StringBuffer();      //allocate memory
	} 
	
	public void run()
	{
	try
	{
		for(int i=1;i<=10;i++)
		{
			sb.append(i+":");
			Thread.sleep(100);
			System.out.println("Appending");
		}
		dataprodover =true;     //when production is overstore true in data production variable
	}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}

	class Consumer extends Thread
	{
		Producer prod;
		
		Consumer(Producer prod)
		{
			this.prod=prod;
		}
		
	 public void run()
	 {
		 try
		 {
			 while(! prod.dataprodover)
			 {
				 Thread.sleep(10);
			 }
		 }catch(InterruptedException e)
		 {
			 e.printStackTrace();
		 }
		 System.out.println(prod.sb);
	 }
	}

