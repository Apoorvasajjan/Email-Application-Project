package emailpack.service;

import java.sql.SQLException;

import emailpack.model.Person;
import emailpack.model.User;

public interface ExamineService {
public void addPerson(Person person)  throws SQLException ;
public void findUserByEmailAddress(String emailAddress) throws SQLException;
public Person myPofile(String person) throws SQLException;

public void composeEmail(User user)  throws SQLException;
public void displayEmailDetails() throws SQLException;
public int deleteEmailByEmailId(int emailId) throws SQLException;
public void searchEmailByReceiver(String receiver) throws SQLException ;
public void searchEmailBySender(String sender) throws SQLException ;
public void searchEmailByEmailId(int emailId) throws SQLException;
}