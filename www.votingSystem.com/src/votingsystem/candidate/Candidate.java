package votingsystem.candidate;

public class Candidate {
	private int id;
	private String name;
	private String party;
	private int age;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getParty() {
		return party;
	}
	public void setParty(String party) {
		this.party = party;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public Candidate(int id, String name, String party, int age) {
//		super();
		this.id = id;
		this.name = name;
		this.party = party;
		this.age = age;
	}
	public Candidate() {
	
	}
	
}
