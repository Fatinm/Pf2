
public class Cat extends Mammal {

	private int numberOfLives;
	
	//Här har du missat this.numberOfLives = numberOfLives
	public Cat(String latinName, String friendlyName, int gestationTime, int numberOfLives){
		super(latinName, friendlyName, gestationTime);
		this.numberOfLives = numberOfLives;
		
	}

	public int getNumberOfLives(){
		return numberOfLives;
	}

	public int setNumberOfLives(int i){
		return i = numberOfLives;

	}



	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		String s;
		if(this.getNumberOfLives() == 1){
			s = "The cat\""+ super.getFriendlyName()+ "/" + this.getLatinName() + "\" nurses for "+this.getGestationTime()+ "months and has" + " " + this.getNumberOfLives()+ " " +"life.\n";
		}else{
			s = "The cat \"" + super.getFriendlyName() + "/" + this.getLatinName() + "\" nurses for " + this.getGestationTime() + "months and has" + " " + this.getNumberOfLives() + " " + "lives.\n";
		}
		return s;
	}

}
