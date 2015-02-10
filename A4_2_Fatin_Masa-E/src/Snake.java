
public class Snake extends Animal{

	private boolean poisonous;

	public Snake(String latinName, boolean poisonous){
		super(latinName);
		this.poisonous = poisonous;
	}

	public boolean isPoisonous(){
		return poisonous;

	}

	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		String s = "";
		if(this.poisonous == true){
			s = "The snake \"" + super.getLatinName() + " " + "\"is poisonous.\n";
		}else{
			s= "The snake \"" + super.getLatinName() + " " + "\" is not poisonous.\n";

		}
		return s;

	}

}
