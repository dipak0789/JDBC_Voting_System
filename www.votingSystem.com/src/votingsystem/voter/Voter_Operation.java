package votingsystem.voter;

import java.util.Scanner;

public class Voter_Operation {
	static Scanner sc =new Scanner(System.in);
	static MultipleVoter mv = new MultipleVoter();
	public static void setVoter() {
		int ch= 1;
		while(ch==1) {
			Voter vt = new Voter();
			System.out.println("Enter Name:");
			String name = sc.next();
			vt.setName(name);
			System.out.println("Enter Age");
			int age = sc.nextInt();
			vt.setAge(age);
			System.out.println("Enter Gender");
			String gender =sc.next();
			vt.setGender(gender);
			System.out.println("Enter Area");
			String area = sc.next();
			vt.setArea(area);
			mv.addVoter(vt);
			System.out.println("Press 1 for add more voters\nPress 2 save all voters");
			ch=sc.nextInt();
			if(ch==2) {
				mv.save();
				
				
			}
		}
	}
}
