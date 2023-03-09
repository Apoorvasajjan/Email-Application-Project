package emailpack.service;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import emailpack.DataBaseConnection;
import emailpack.model.Person;
import emailpack.model.User;

public class ExamineServiceImplimentation implements ExamineService {
	Connection connection = null;
	PreparedStatement pStatement = null;

	public ExamineServiceImplimentation() throws SQLException, FileNotFoundException {
		connection = DataBaseConnection.getConnection();
		Scanner sc = new Scanner(System.in);
	}

	@Override
	public void addPerson(Person person) throws SQLException {
		pStatement = connection.prepareStatement("insert into details values(?,?,?,?,?,?,?)");
		pStatement.setString(1, person.getFirstName());
		pStatement.setString(2, person.getLastName());
		pStatement.setString(3, person.getGender());
		pStatement.setString(4, person.getDateOfBirth());
		pStatement.setString(5, person.getMobileNo());
		pStatement.setString(6, person.getEmailAddress());// https://www.tutorialspoint.com/validate-email-address-in-java
		// https://www.geeksforgeeks.org/how-to-validate-a-password-using-regular-expressions-in-java/

		pStatement.setString(7, person.getPassword());
		int res = pStatement.executeUpdate();
		if (res == 1) {
			System.out.println(":->------Created Account successfully------:->");
		}
	}

	@Override
	public void findUserByEmailAddress(String emailAddress) throws SQLException {
		pStatement = connection.prepareStatement("select *from details where emailAddress=?");
		pStatement.setString(1, emailAddress);
		ResultSet rs = pStatement.executeQuery();
		rs.next();
		Person person = new Person(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
				rs.getString(6), rs.getString(7));
		System.out.println("Login successfully");
	}

	@Override
	public Person myPofile(String person) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void composeEmail(User user) throws SQLException {
		// TODO Auto-generated method stub
		pStatement = connection.prepareStatement("insert into emailtab values(?,?,?,?,?)");
	pStatement.setInt(1,user.getEmailId());
		pStatement.setString(2, user.getReceiver());
		pStatement.setString(3, user.getSender());
		pStatement.setString(4, user.getSubject());
		pStatement.setString(5, user.getBody());
		int result = pStatement.executeUpdate();
		if (result == 1) {
			System.out.println(":->------Mail Sent successfully------:->");
		}
	}

	@Override
	public void displayEmailDetails() throws SQLException {
		// TODO Auto-generated method stub
		pStatement = connection.prepareStatement("select * from emailtab");
		ResultSet resultSet = pStatement.executeQuery();
		while (resultSet.next())// next() --brings the cursor to the first record
		// returns true
		{
			int emailId = resultSet.getInt(1);
			String receiver = resultSet.getString(2);
			String sender = resultSet.getString(3);
			String subject = resultSet.getString(4);
			String body = resultSet.getString(5);

			User user = new User(emailId, receiver, sender, subject, body);
			System.out.println(user);
		}
	}
	/*
	 * @Override public void deleteEmailByReceiver(String receiver) throws
	 * SQLException { // TODO Auto-generated method stub
	 * 
	 * System.out.println("Enter the EmailId you want to delete");
	 * pStatement=connection.
	 * prepareStatement("delete from emailtable where receiver=?");
	 * pStatement.setString(1,receiver); boolean resultSet=pStatement.execute();
	 * System.out.println("receiver");
	 * 
	 * }
	 * 
	 * @Override public void deleteEmailByEmailId(int emailId) throws SQLException {
	 * // TODO Auto-generated method stub
	 * 
	 * }
	 * 
	 * @Override public void deleteEmailByEmailId(int emailId) throws SQLException {
	 * // TODO Auto-generated method stub
	 * 
	 * }
	 */

	@Override
	public int deleteEmailByEmailId(int emailId) throws SQLException {
		// TODO Auto-generated method stub
	//	System.out.println("Enter the EmailId you want to delete");
		
		 pStatement=connection.prepareStatement("delete FROM emailtab WHERE emailId=?");
		 pStatement.setInt(1,emailId); 
		 boolean resultSet=pStatement.execute();
		  System.out.println(resultSet);
		return emailId;
		 
	}

	public void searchEmailByReceiver(String receiver) throws SQLException {
		// TODO Auto-generated method stub
		pStatement=connection.prepareStatement("select *from emailtab where receiver=?");
		pStatement.setString(1,receiver);
		ResultSet rs=pStatement.executeQuery();
		User user=null;
		while(rs.next()) {
	   user=new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
		System.out.println(user);
		}
		
		
	}

	public void searchEmailBySender(String sender) throws SQLException {
		// TODO Auto-generated method stub
		pStatement=connection.prepareStatement("select *from emailtab where sender=?");
		pStatement.setString(1,sender);
		ResultSet rs=pStatement.executeQuery();
		User user=null;
		while(rs.next()) {
			 user=new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
		System.out.println(user);
	}
		//return student;
	}

	@Override
	public void searchEmailByEmailId(int emailId) throws SQLException {
		// TODO Auto-generated method stub
		pStatement=connection.prepareStatement("select *from emailtab where emailId=?");
		pStatement.setInt(1,emailId);
		ResultSet rs=pStatement.executeQuery();
		User user=null;
		while(rs.next()) {
			 user=new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
		System.out.println(user);
	}
}
}
