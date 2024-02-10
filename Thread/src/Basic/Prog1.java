// either use interface Runnable or class Thread to create thread

package Basic;

//class FirstThread extends Thread  

class FirstThread implements Runnable
{
	public void run()
	{
		for(int i=0;i<10;i++)
		{
			System.out.println(i);
		}
	}
}
public class Prog1 {

	public static void main(String[] args) {
		
		FirstThread  ft = new FirstThread();
		Thread t = new Thread(ft);
		t.start();
	}

}
