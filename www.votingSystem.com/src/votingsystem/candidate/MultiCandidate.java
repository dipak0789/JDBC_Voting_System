package votingsystem.candidate;

import java.util.ArrayList;

import votingsystem.database.Database;

public class MultiCandidate {
	ArrayList <Candidate>list = new ArrayList<Candidate>();
	
	public MultiCandidate(){
		this.list = new ArrayList<Candidate>();
	}
	
	public void addCandidate(Candidate cd) {
		list.add(cd);
	}
	public void save() {
		Database.saveCandidate(list);
	}
}
