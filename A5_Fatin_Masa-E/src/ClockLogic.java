
public class ClockLogic implements ClockInterface {
	private DigitalClockGUI clockGUI;
	private int alarmHour;
	private int alarmMinute;
	
	private int finalHour;
	private int finalMinute;
	
	public ClockLogic(DigitalClockGUI clockIn){
		this.clockGUI = clockIn;
		
		Thread t = new ClockThread (this);
		t.start();
	}
	
	public void setAlarm(int hours, int minutes){
		this.alarmHour = hours;
		this.alarmMinute = minutes;
		
	}
	
	public void clearAlarm(){
		
	}
	
	
	
	@Override
	public void update(int hours, int minute, int second) {
		// TODO Auto-generated method stub

	}

}
