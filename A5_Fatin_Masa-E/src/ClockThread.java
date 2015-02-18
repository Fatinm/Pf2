

import java.util.Calendar; 

public class ClockThread extends Thread{

	private boolean running = true;
	private ClockInterface clockInterface;

	
	public ClockThread (ClockInterface ci){
		this.clockInterface = ci;
	}
	
	@Override
	
	public void run(){
			while (running) {
				
				Calendar now = Calendar.getInstance();
				clockInterface.update(now.get(Calendar.HOUR_OF_DAY), now.get(Calendar.MINUTE), now.get(Calendar.SECOND));
				
				try {
					Thread.sleep(900);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
		}
	}
	
}