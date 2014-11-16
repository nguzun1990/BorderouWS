package md.usarb.borderou.entities.licenta;

public class Semestru implements EntityInterface {
	
	String name;
	
	Integer value;
	
	public Semestru(Integer value) {
		this.name =  "Semestrul " + value;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

}
