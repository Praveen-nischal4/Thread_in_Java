package Basic;

import java.io.IOException;

class StopThread extends Thread
{
	boolean stop=false;
	
	public void run()
	{
		for(int i=0;i<100;i++)
		{
			System.out.println(i);
			
			if(stop)
				return ;      //coming out of run method 
		}
	}
}
public class Prog2 {

	public static void main(String[] args) throws IOException {

            StopThread st =new StopThread();
            Thread t =new Thread(st);
             t.start();
             
             System.in.read();
             st.stop =true;

	}

}


