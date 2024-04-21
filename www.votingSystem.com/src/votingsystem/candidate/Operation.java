package votingsystem.candidate;

import java.util.Scanner;

import votingsystem.database.Database;
import votingsystem.home.Test;

public class Operation {
	static Scanner sc = new Scanner(System.in);
	static MultiCandidate md = new MultiCandidate();
	
	public  static void setCandidate() {
		int ch=1;
		while(ch==1) {
			
			Candidate cd = new Candidate();
			System.out.println("Enter name:");
			String name = sc.next();
			cd.setName(name);
			System.out.println("Enter Party:");
			String party = sc.next();
			cd.setParty(party);
			System.out.println("Enter your age :");
			int age =sc.nextInt();
			cd.setAge(age);
			
			
			md.addCandidate(cd);
			System.out.println("Press 1 for add more Candidates\nPress 2 for save all candidates");
			ch = sc.nextInt();
			if(ch==2) {
			md.save();
				
			}
			
		}
	}
	
	public void candidateOperation() {
		System.out.println("Press 1 for Register\nPress 2 for Update Candidate\nPress 3 for Display Candidate\nPress 4 for Delete Candidate\nPress 5 for Exit");
		int ch = sc.nextInt();
		boolean a = true;
		while(a) {
		switch(ch) {
		case 1:
			Operation.setCandidate();
			break;
		case 2:
			Database.updateCandidate();
			break;
		case 3:
			Database.displayCandidate();
			break;
		case 4:
			Database.deleteCandidate();
			break;
		case 5:
            Test.Start();
			break;
			
		}
		break;
		}
	}
}
