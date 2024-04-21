package votingsystem.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import votingsystem.candidate.AgeException;
import votingsystem.candidate.Candidate;
import votingsystem.voter.Voter;

public class Database {
	static Scanner sc = new Scanner(System.in);
	public static void saveCandidate(ArrayList<Candidate>pd) {
		
		Connection co = Connect.getConnect();
		try {
			int op = 0;
			PreparedStatement ps = co.prepareStatement("Insert INTO candidate(name,party,age)VALUES(?,?,?)");
			for(Candidate cd: pd) {
				String name = cd.getName();
				String party = cd.getParty();
				int age = cd.getAge();
				if(age<18) {
					throw new AgeException();
					
				}
				else {
					ps.setString(1, name );
				    ps.setString(2, party);
					ps.setInt(3, age);
					int a = ps.executeUpdate();
					op = op+a;
					System.out.println(op+"Candidate added succefully");
				}			 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (AgeException e) {
		System.out.println("Sorry Your are not eligible ");
		}
		
	}
	
	public static void updateCandidate() {
		Connection co = Connect.getConnect();
		
		try {
			System.out.println("Press 1 for update name\nPress 2 for Update Party\nPress 3 for update Age");
			int ch = sc.nextInt();
			switch(ch) {
			case 1:
				PreparedStatement st = co.prepareStatement("UPDATE candidate SET name =? WHERE id=? ");
				System.out.println("Enter new name:");
				st.setString(1, sc.next());
				System.out.println("Enter id of Candidate: ");
				st.setInt(2, sc.nextInt());
				int ex = st.executeUpdate();
				System.out.println(ex+ "Candidate name updated");
				break;
			case 2:
				PreparedStatement st1 = co.prepareStatement("UPDATE candidate SET party =? WHERE id=? ");
				System.out.println("Enter new Party:");
				st1.setString(1, sc.next());
				System.out.println("Enter id of Candidate: ");
				st1.setInt(2, sc.nextInt());
				int ex1 = st1.executeUpdate();
				System.out.println(ex1+ "Candidate name updated");
				break;
			case 3:
				PreparedStatement st2 = co.prepareStatement("UPDATE candidate SET age =? WHERE id=? ");
				System.out.println("Enter new age:");
				st2.setInt(1, sc.nextInt());
				System.out.println("Enter id of Candidate: ");
				st2.setInt(2, sc.nextInt());
				int ex2 = st2.executeUpdate();
				System.out.println(ex2+ "Candidate name updated");
				break;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public static void deleteCandidate() {
		Connection co = Connect.getConnect();
		System.out.println("Enter candidate name to delete");
		try {
			PreparedStatement st= co.prepareStatement("Delete FROM candidate where id=?");
			System.out.println("Are you want to delete data");
			System.out.println("Press 1 for delete \nPress 2 for cancel");
			int sure  = sc.nextInt();
			if(sure==1) {
				System.out.println("Enter ID to delete");
				int id = sc.nextInt();
				st.setInt(1, id);
				int ex= st.executeUpdate();
				if(ex==0) {
					System.out.println("Candidate ID not available in tabel");
				}else {
					System.out.println(ex+"Deleted Sucessfully");
				}
			}else {
				System.out.println("Canceled");
			}			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void displayCandidate() {
		Connection co = Connect.getConnect();
		try {
			Statement st = co.createStatement();
			ResultSet executeQuery = st.executeQuery("SELECT * FROM candidate");
			while(executeQuery.next()) {
				int ID = executeQuery.getInt("ID");
				String name = executeQuery.getString("Name");
				String party = executeQuery.getString("Party");
				int age = executeQuery.getInt("Age");
//				int votes = executeQuery.getInt("Votes");
				System.out.println("Id: "+ID+" Name: "+name+" Party: "+party+" Age: "+age);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	
	
}
