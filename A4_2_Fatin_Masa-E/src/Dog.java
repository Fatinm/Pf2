
public class Dog extends Mammal {

	private boolean stupid;


	public Dog(String latinName, String friendlyName, int gestationTime, boolean stupid){
		super (latinName, friendlyName, gestationTime);
		this.stupid = stupid;
	}

	
	public boolean isStupid(){
		return stupid;
	}



	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		String s;
		if(stupid){
			s = "\n" + "The dog \"" + " " + super.getFriendlyName() + "/" + this.getLatinName()+ "\" nurses for " + this.getGestationTime()+ "months and is stupid.\n";
		}else{
			s ="The dog\""+ " " +  super.getFriendlyName() + "/" + this.getLatinName()+ "\" nurses for " + this.getGestationTime() + "months and isn't stupid.\n";
		}
		return s;
	}

}
