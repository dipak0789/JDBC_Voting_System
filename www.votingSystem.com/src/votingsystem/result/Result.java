package votingsystem.result;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import votingsystem.database.Connect;

public class Result {
    public void setResult() {
    	System.out.println("Results of Voting");
        Connection co = Connect.getConnect();
        try {
            Statement st = co.createStatement();
            ResultSet pst = st.executeQuery("SELECT candidate.id, candidate.name, candidate.party, voting.votes " +
                                            "FROM candidate JOIN voting ON candidate.id = voting.id");
            while (pst.next()) {
                int candidateId = pst.getInt("id");
                String candidateName = pst.getString("name");
                String candidateParty = pst.getString("party");
                int votes = pst.getInt("votes");
                System.out.println("id: "+candidateId+"\tname: "+candidateName+"\tparty: "+candidateParty+"\tvotes:"+votes);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
        	System.out.println("Winner of Voting");
            Statement st = co.createStatement();
            ResultSet pst = st.executeQuery("SELECT candidate.id, candidate.name, candidate.party, voting.votes "+"FROM candidate JOIN voting ON candidate.id = voting.id " +"ORDER BY voting.votes DESC ");
            if (pst.next()) {
                int candidateId = pst.getInt("id");
                String candidateName = pst.getString("name");
                String candidateParty = pst.getString("party");
                int votes = pst.getInt("votes");
                System.out.println("id: " + candidateId + "\tname: " + candidateName + "\tparty: " + candidateParty + "\tvotes:" + votes);
            } else {
                System.out.println("No winner found.");
            }
            System.out.println("*");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}