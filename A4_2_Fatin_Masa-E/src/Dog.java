
public class Dog extends Mammal {

	private boolean stupid;


	public Dog(String latinName, int gestationTime, boolean stupid){
		super (latinName, gestationTime);
		this.stupid = stupid;
	}

	public Dog(String friendlyName, String latinName, boolean stupid){
		super(latinName, 20);
		this.stupid = stupid;
		
		super.setFriendlyName(friendlyName);

	}

	public boolean isStupid(){
		return stupid;
	}



	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		String s;
		if(stupid){
			s = "\n" + "The dog \"" + " " + this.getLatinName()+ "\" nurses for " + this.getGestationTime()+ "months and is stupid.\n";
		}else{
			s ="The dog\""+ " " + this.getLatinName()+ "\" nurses for " + this.getGestationTime() + "months and isn't stupid.\n";
		}
		return s;
	}

}
