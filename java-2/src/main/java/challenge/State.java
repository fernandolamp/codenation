package challenge;

public class State {

	private String uf;
	private String desc;

	public State(String uf,String desc){
		this.uf = uf;
		this.desc = desc;
	}

	public String getUf() {
		return this.uf;
	}

	public String getName() {
		return this.desc;
	}

}
