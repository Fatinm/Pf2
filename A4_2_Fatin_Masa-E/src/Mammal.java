
public abstract class Mammal extends Animal {
	private int gestationTime;
	
	public Mammal(String latinName, String friendlyName, int gestationTime){
		super (latinName, friendlyName);
		this.gestationTime = gestationTime;
	}
	
	public int getGestationTime() {
		return gestationTime;
	}
	
}
