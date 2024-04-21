package votingsystem.voter;

import java.util.ArrayList;

import votingsystem.database.Database;

public class MultipleVoter {
	ArrayList<Voter> list = new ArrayList<Voter>();
	
	public MultipleVoter() {
		this.list =  new  ArrayList<Voter>();
	}
	public void addVoter(Voter vt) {
		list.add(vt);
	}
	public void save() {
		DatabaseVoter.saveVoter(list);
	}
}
