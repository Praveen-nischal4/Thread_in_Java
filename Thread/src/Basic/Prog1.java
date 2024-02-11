// either use interface Runnable or class Thread to create thread

package Basic;

//class FirstThread extends Thread  

class FirstThread implements Runnable
{
	public void run()         // logic inside run() will execute as threas start
	{
		for(int i=0;i<10;i++)
		{
			System.out.println(i);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
