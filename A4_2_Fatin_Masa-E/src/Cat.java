
public class Cat extends Mammal {

	private int numberOfLives;

	public Cat(String latinName, int gestationTime, int numberOfLives){
		super(latinName, gestationTime);
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
			s = "The cat\"" + this.getLatinName() + "\" nurses for "+this.getGestationTime()+ "months and has" + " " + this.getNumberOfLives()+ " " +"life.\n";
		}else{
			s = "The cat \"" + this.getLatinName() + "\" nurses for " + this.getGestationTime() + "months and has" + " " + this.getNumberOfLives() + " " + "lives.\n";
		}
		return s;
	}

}
