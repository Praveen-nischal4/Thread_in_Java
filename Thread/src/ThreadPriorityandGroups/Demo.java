package ThreadPriorityandGroups;

import MultiTaskingThread.MyReservation;

class Reservation implements Runnable
{
	 @Override
	 public void run() {
       System.out.println("I am Reservation Thread");		
	 }	
}

class Cancellation implements Runnable
{
	@Override
	public void run() {
       System.out.println("I am Cancellation Thread");
	}	
}


public class Demo {

	public static void main(String[] args) {
 
		Reservation res = new Reservation();
		Cancellation can = new Cancellation();
		
		ThreadGroup tg = new ThreadGroup("First Group");      //create group tg
		
		//create 2 thread in this group
		
		Thread t1 = new Thread(tg,res,"First Thread");
		Thread t2 = new Thread(tg,res,"Second Thread");
		
		//create another group tg1  inside tg
		
		ThreadGroup tg1 = new ThreadGroup(tg,"Second Group");
		
		//add 2 thread in this subgroup or tg1 group
		
		Thread t3 = new Thread(tg1,can,"First Thread");
		Thread t4 = new Thread(tg1,can,"Second Thread");
		
		//method of Thread group
		
		System.out.println(tg1.getParent());
        tg1.setMaxPriority(8);
        
        // know the group of thread
        
        System.out.println(t1.getThreadGroup());
        System.out.println(t3.getThreadGroup());
        
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        
        System.out.println("No of Threads active in group : "+tg.activeCount());
	}

}
