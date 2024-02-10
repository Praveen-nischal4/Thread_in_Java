package SingleTaskThread;

class CalculateFact implements Runnable
{
	private int num;          //instance variable
	
	CalculateFact(int num)             //constructor
	{
		
		this.num=num;
	}
	
	@Override
	public void run()
	{
		long fact =1;
		for(int i=1;i<=num;i++)
		{
			fact*=i;
		}
		System.out.println("Factorial of a "+num+" is "+fact);
		System.out.println("Factorial calculation is compleetd");
	}	
}


public class SingleThread {

	public static void main(String[] args) {

		int num=55;
		
		CalculateFact c = new CalculateFact(num);
		Thread t = new Thread(c);
       
		t.start();
		
		try
		{
			t.join(2000);
		}catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		System.out.println("All task is compleetd");
		
	}

}
