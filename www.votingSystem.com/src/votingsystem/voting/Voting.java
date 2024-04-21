package votingsystem.voting;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import votingsystem.database.Connect;

public class Voting {
	static Scanner sc=new Scanner(System.in);
	int op = 0;
	public void setId(){
		Connection co=Connect.getConnect();
		
		try {
			Statement st=co.createStatement();
			ResultSet pst=st.executeQuery("Select ID from candidate");
			PreparedStatement destination=co.prepareStatement("Insert into voting (id) VALUES(?)");
			while(pst.next()) {
				int id=pst.getInt("id");
				destination.setInt(1, id);
			   int  a=destination.executeUpdate();
			   op = op+a;
				
			}
		
			System.out.println(op+" Successful");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void startVoting() {
		Connection co = Connect.getConnect();
		System.out.println("Enter Voter ID:");
		int voterId = sc.nextInt();
		try {
			Statement st1 = co.createStatement();
			ResultSet rst = st1.executeQuery("SELECT id FROM voter");
			boolean found = false;
			
			while(rst.next()) {
				int ids = rst.getInt("id");
				while(voterId == ids) {
					System.out.println("Voter Found Successfully");
					Statement stmt = co.createStatement();
					ResultSet trashIds =stmt.executeQuery("SELECT ID FROM trash;");
					boolean check =false;
					while(trashIds.next()) {
						int existingId = trashIds.getInt("id");
						if(existingId == voterId) {
							System.out.println("Already Voted");
							check = true;
							break;
						}
					}
					if(check==false) {
						PreparedStatement trash =co.prepareStatement("INSERT INTO trash (id)VALUES(?);");
						trash.setInt(1, voterId);
						trash.executeUpdate();
						Voting.setVote(ids);
						
					}
					found = true;
					break;	
					}
					
				}
				if(found==false) {
					System.out.println("Invalid Voter");
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void finalCandidate() {
		Connection co =Connect.getConnect();
		try {
			Statement st =co.createStatement();
			ResultSet rst = st.executeQuery("SELECT * FROM candidate;");
			while(rst.next()) {
				int id = rst.getInt("id");
				String name = rst.getString("name");
				String party = rst.getString("party");
				int age = rst.getInt("age");
				System.out.println("ID "+id+"Name: "+name+" Party: "+party+" Age: "+age);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void setVote(int ids) {
		Voting.finalCandidate();
		Scanner sc = new Scanner(System.in);
		System.out.println("Choose your Candiddate");
		int id =sc.nextInt();
		
		Connection co =Connect.getConnect();
		
		try {
			PreparedStatement pst = co.prepareStatement("SELECT votes FROM voting WHERE id=?;");
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				int singleVote =  rs.getInt("votes");
				//increase vote by one
				singleVote = singleVote+1;
				//send increase vote back to table;
				PreparedStatement voting = co.prepareStatement("UPDATE voting SET votes=? WHERE id=?;");
				voting.setInt(1, singleVote);
				voting.setInt(2, id);
				voting.executeUpdate();
				System.out.println("Voting Successful");	
				}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
//	
}