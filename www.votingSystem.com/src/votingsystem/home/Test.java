package votingsystem.home;

import java.util.Scanner;

import votingsystem.candidate.Operation;
import votingsystem.resetData.Reset;
import votingsystem.result.Result;
import votingsystem.voter.VoterApp;
import votingsystem.voter.Voter_Operation;
import votingsystem.voting.Voting;

public class Test {
	static {
		System.out.println("Welcome to election");
	}
	static Scanner sc = new Scanner(System.in);
	static Operation op = new Operation();
	static Voting vt = new Voting();
	static Reset rs = new Reset();
	static Result rt= new Result();
	public static void Start() {
		while(true) {
		System.out.println("Press 1 for Candidate\nPress 2 for Voter\nPress 3 for set Voting\nPress 4 for Start Voting\nPress5 for Reset All Data\nPress 6 for Result");
		int ch = sc.nextInt();
		switch(ch) {
		case 1:
			op.candidateOperation();
			break;
		case 2:
			VoterApp.getAllVoter();
			break;
		case 3:
			vt.setId();
			break;
		case 4:
			vt.startVoting();
			break;
		case 5:
			rs.resetTabels();
			break;
		case 6:
			rt.setResult();
			break;
		   }
	   }
	}
	public static void main(String[] args) {
		Test.Start();
	}
}
