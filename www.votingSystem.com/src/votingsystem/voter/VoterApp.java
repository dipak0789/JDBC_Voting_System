package votingsystem.voter;

import java.util.Scanner;

import votingsystem.home.Test;

public class VoterApp {
	public static void getAllVoter() {
		Scanner sc =new Scanner (System.in);
		System.out.println("Press 1 add Voters\nPress 2 for Update Voters\nPress 3 for Display Voters\nPress 4 for Delete Voters\nPress 5 for Exit");
		boolean a = true;
		int ch =  sc.nextInt();
		while(a) {
			switch(ch) {
			case 1:
				Voter_Operation.setVoter();
				break;
			case 2:
				DatabaseVoter.updateVoter();
				break;
			case 3:
				DatabaseVoter.displayVoter();
				break;
			case 4:
				DatabaseVoter.deleteVoter();
				break;
			case 5:
				Test.Start();
				break;
					
			}
			break;
		}
		
	}
}
