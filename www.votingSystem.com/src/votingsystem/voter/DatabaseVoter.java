package votingsystem.voter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import votingsystem.candidate.AgeException;
import votingsystem.database.Connect;

public class DatabaseVoter {
	static Scanner sc = new Scanner(System.in);
	public static void saveVoter(ArrayList<Voter>vr) {
		Connection co = Connect.getConnect();
		
		try {
			int op =0;
			 PreparedStatement ps= co.prepareStatement("INSERT INTO voter(name,age,gender,area)VALUES(?,?,?,?) ");
			for(Voter vt: vr) {
				String name = vt.getName();
				int age = vt.getAge();
				String gender = vt.getGender();
				String area=  vt.getArea();
				if(age<18) {
					throw new AgeException();
				}else {
					ps.setString(1, name);
					ps.setInt(2, age);
					ps.setString(3, gender);
					ps.setString(4, area);
					int b = ps.executeUpdate();
					op = op+b;
					System.out.println(op+ "Voter added succefully");
				}
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AgeException e) {
			System.out.println("Your not eligible for Voting");
		}
		
	}
	
	public static void updateVoter() {
		Connection co = Connect.getConnect();
		try {
			int ch = sc.nextInt();
			switch (ch) {
			case 1:
				PreparedStatement ps = co.prepareStatement("UPDATE voter SET name = ? WHERE id = ?");
				System.out.println("Enter new name:");
				ps.setString(1, sc.next());
				System.out.println("Ener id of Voter:");
				ps.setInt(2, sc.nextInt());
				int ex1 = ps.executeUpdate();
				System.out.println(ex1+" Voter name Updated");
				break;
			case 2:
				PreparedStatement ps1 = co.prepareStatement("UPDATE voter SET age = ? WHERE id = ?");
				System.out.println("Enter new age:");
				ps1.setInt(1, sc.nextInt());
				System.out.println("Enter voter id:");
				ps1.setInt(2, sc.nextInt());
				int ex2 = ps1.executeUpdate();
				System.out.println(ex2 +" Voter age updated");
				break;
			case 3:
				PreparedStatement ps2 = co.prepareStatement("UPDATE voter SET gender = ? WHERE id = ?");
				System.out.println("Enter new gender:");
				ps2.setInt(1, sc.nextInt());
				System.out.println("Enter voter id:");
				ps2.setInt(2, sc.nextInt());
				int ex3 = ps2.executeUpdate();
				System.out.println(ex3 +" Voter gender updated");
				break;
			case 4:
				PreparedStatement ps3 = co.prepareStatement("UPDATE voter SET area = ? WHERE id = ?");
				System.out.println("Enter new area:");
				ps3.setString(1, sc.next());
				System.out.println("Enter voter id:");
				ps3.setInt(2, sc.nextInt());
				int ex4 = ps3.executeUpdate();
				System.out.println(ex4 +" Voter age updated");
				break;
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	 public static void displayVoter(){
		 Connection co = Connect.getConnect();
		 try {
			Statement st =co.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM voter");
			while(rs.next()) {
				int ID = rs.getInt("ID");
				String name = rs.getString("Name");
				int age = rs.getInt("Age");
				String gender = rs.getString("Gender");
				String area = rs.getString("Area");
				System.out.println("Id: "+ID+" Name: "+name+" Age: "+age+" Gender: "+gender+" Area: "+area);

			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 
	 public static void deleteVoter() {
		 Connection co = Connect.getConnect();
			System.out.println("Enter Voter name to delete");
			try {
				PreparedStatement st= co.prepareStatement("Delete FROM voter where name=?");
				System.out.println("Are you want to delete data");
				System.out.println("Press 1 for delete \nPress 2 for cancel");
				int sure  = sc.nextInt();
				if(sure==1) {
					System.out.println("Enter name to Delete");
					String name = sc.next();
					st.setString(1, name);
					int ex= st.executeUpdate();
					if(ex==0) {
						System.out.println("Voter not available in Table");
					}else {
						System.out.println(ex+" Deleted Sucessfully");
					}
				}else {
					System.out.println("Canceled");
				}			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	 }
}
