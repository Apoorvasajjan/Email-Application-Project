package emailpack.model;
public class Person {

  private String firstName;
  private String lastName;
  private String gender;
  private String  dateOfBirth;
  private String mobileNo;
  private String emailAddress;
  private String password;

public Person(String firstName, String lastName, String gender, String dateOfBirth, String mobileNo, String emailAddress,
		String password) {
	super();
	this.firstName = firstName;
	this.lastName = lastName;
	this.gender = gender;
	this.dateOfBirth = dateOfBirth;
	this.mobileNo = mobileNo;
	this.emailAddress = emailAddress;
	this.password = password;

}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String getDateOfBirth() {
	return dateOfBirth;
}
public void setDateOfBirth(String dateOfBirth) {
	this.dateOfBirth = dateOfBirth;
}
public String getMobileNo() {
	return mobileNo;
}
public void setMobileNo(String mobileNo) {
	this.mobileNo = mobileNo;
}
public String getEmailAddress() {
	return emailAddress;
}
public void setEmailAddress(String emailAddress) {
	this.emailAddress = emailAddress;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}


@Override
public String toString() {
	return "User [firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender + ", dateOfBirth="
			+ dateOfBirth + ", mobileNo=" + mobileNo + ", emailAddress=" + emailAddress + ", password=" + password
			+  "]";
}
  
}
  
