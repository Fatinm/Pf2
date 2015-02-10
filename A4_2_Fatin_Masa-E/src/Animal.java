
public abstract class Animal {

	private String latinName = "";
	private String friendlyName = "";



	public Animal(String latinName){
		this.latinName = latinName;
	}

	public String getLatinName(){
		return latinName;
	}


	public void setFriendlyName(String name){

	}

	public String getFriendlyName(){
		return friendlyName;
	}


	abstract String getInfo();
}