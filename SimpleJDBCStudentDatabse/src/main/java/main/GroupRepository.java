package main;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;

import data.Group;
import data.Student;

public class GroupRepository extends Repository{
	
	public GroupRepository() {
		super();
	}

	public boolean install(){
		try {
			Statement st = connection.createStatement();
			st.executeUpdate("DROP TABLE IF EXISTS groups;");
			st.executeUpdate("CREATE TABLE groups(\r\n" + 
					"    id INTEGER PRIMARY KEY AUTOINCREMENT, \r\n" + 
					"    name VARCHAR(30),\r\n" + 
					"    code VARCHAR(10)\r\n" + 
					" );");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean addGroup(Group group) {
		try {
			Statement st = connection.createStatement();
			String execSQL = "INSERT INTO groups VALUES(null, '"+group.getName()
														+"', '"+group.getCode()+"');";
//			System.out.println(execSQL);
			st.executeUpdate(execSQL);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean updateGroup(Group group) {
		try {
			Statement st = connection.createStatement();
			String execSQL = "UPDATE groups SET name ='"+group.getName()
											+"', code='"+group.getCode()
											+"'  WHERE id='"+group.getId()+"';";
//			System.out.println(execSQL);
			st.executeUpdate(execSQL);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}	
	public boolean deleteGroup(Group group) {
		try {
			Statement st = connection.createStatement();
			String execSQL = "DELETE from groups WHERE id="+group.getId()+";";
//			System.out.println(execSQL);
			st.executeUpdate(execSQL);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public ArrayList<Group> all() {
		ArrayList<Group> groups = new ArrayList<>();
		try {
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM groups;");
			while(rs.next()) {
/*				System.out.println(String.format("%-30s",rs.getString("fulName"))+" |"+ 
									rs.getString("dob")+" | "+ 
									rs.getString("mark") );

*/				groups.add(new Group(rs.getInt("id"),
									rs.getString("name"), 
									rs.getString("code")));
			
			}
			return groups;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		
	}

}
