package emailpack;

import java.io.IOException;

import java.sql.SQLException;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import emailpack.model.Person;
import emailpack.model.User;
import emailpack.service.ExamineServiceImplimentation;

public class TestServices {
	
	
	private static int emailId;

	private static boolean isValid(String emailAddress) {
		// TODO Auto-generated method stub
		 String regex ="^[a-zA-Z0-9_+&*-]+(?:\\."+
                 "[a-zA-Z0-9_+&*-]+)*@" +
                 "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                 "A-Z]{2,7}$";
                   
	      return emailAddress.matches(regex);
	
	}
	
	private static boolean isValidReceiver(String receiver) {
		// TODO Auto-generated method stub
		 String regex ="^[a-zA-Z0-9_+&*-]+(?:\\."+
                 "[a-zA-Z0-9_+&*-]+)*@" +
                 "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                 "A-Z]{2,7}$";
                   
	      return receiver.matches(regex);
	
	}
	public static boolean isValidPassword1(String password)
	{
		String regex = "^(?=.*[0-9])"
                + "(?=.*[a-z])(?=.*[A-Z])"
                + "(?=.*[@#$%^&+=])"
                + "(?=\\S+$).{8,20}$";
 Pattern p = Pattern.compile(regex);
 if (password == null) {
     return false;
 }
 Matcher m = p.matcher(password);

 return m.matches();
	}
	
	public static boolean isValidMobileNo(String str)  
	{  
		Pattern ptrn = Pattern.compile("(0/91)?[7-9][0-9]{9}");  
		Matcher match = ptrn.matcher(str);  
		//returns a boolean value  
		return (match.find() && match.group().equals(str));  
		}  
	
	public static void main(String[] args) throws SQLException, IOException {
	Scanner sc=new Scanner(System.in);
	ExamineServiceImplimentation menu=new ExamineServiceImplimentation(); 
	char ch=' ';
	do {
		System.out.println("  ");
		System.out.println("*************************************************************************************");
		System.out.println("   ");
		System.out.println("                         -**-WELCOME TO EMAIL APPLICATION-**-                        ");
		System.out.println("   ");
		System.out.println("*************************************************************************************");
		System.out.println("  ");
	System.out.println("choose the option");
	System.out.println("------------------------------------------------------------------------------------");
	System.out.println(" 1-Register(new user register here) ");
	System.out.println("     ");
	System.out.println(" 2-Login ");
	System.out.println("------------------------------------------------------------------------------------");
	
	int option=sc.nextInt();
	switch(option) {
	case 1:
		
		System.out.print("Enter firstName:");
		String firstName=sc.next();
		System.out.print("Enter lastName :");
		String lastName=sc.next();
		System.out.print("Enter gender :");
		String gender=sc.next();
	//	System.out.print("Enter dateOfBirth :");
		//String dateOfBirth=sc.next());
		  System.out.print("Enter a date (yyyy-mm-dd): ");
	        String inputDate = sc.next();

	        try {
	            LocalDate dateOfBirth = LocalDate.parse(inputDate);
	            System.out.println("The date you entered is: " + dateOfBirth);
	        } catch (DateTimeParseException e) {
	            System.out.println("Invalid date format. Please enter date in yyyy-mm-dd format.");
	        }
		System.out.print("Enter mobileNo :");
		String mobileNo=sc.next();
		if (isValidMobileNo(mobileNo))  {
			
			System.out.println("It is a valid mobile number.");   
		}	else {  
			System.out.println("Entered mobile number is invalid.");      
		mobileNo=sc.next();
		}
		System.out.print("Enter emailAddress :");
		String emailAddress=sc.next();
	    boolean result=isValid(emailAddress);
	    if(!result) {
	    	System.out.println("emailid validation is failed please enter correct emailId ");
	    	emailAddress=sc.next();
	    }
	    
		System.out.print("Enter password:");
	String password=sc.next();
	
		 boolean res=isValidPassword1(password);	 
		 if(!res) {
			 System.out.println("password validation is failed please enter correct password");
			 password=sc.next();
	        }
		
		Person person = new Person(firstName,lastName,gender,inputDate,mobileNo,emailAddress,password);
		try {
			menu.addPerson(person);
		}catch(SQLException e) {
			System.out.println("Creating account "+e.getMessage());
		}
		break;
	case 2:
		try {
			System.out.print("Enter emailAddress :");
			emailAddress=sc.next();
		  menu.findUserByEmailAddress(emailAddress);
			}catch(SQLException e) {
		System.out.println("please enter registered emailId");
		break;
		}
		//System.out.println("Do you want to proceed with further steps ");
		char ch1=' ';
		do {
			
			System.out.println("Do you want to proceed with further steps yes/No");
			ch1=sc.next().charAt(0);
			System.out.println("--------------------------------------------------------------------------------");
			System.out.println("choose the option");
			System.out.println("1.Compose Email \n 2.Inbox \n 3.delete Email \n 4.search Email \n 5.logout");
			System.out.println("--------------------------------------------------------------------------------");

			int option1=sc.nextInt();
			switch(option1) {
			case 1:
				
				
				System.out.println("compose the mail");
				try {
					menu.displayEmailDetails();
				} catch (SQLException e) {
					System.out.println("All Emails-->"+e.getMessage());
				}
				
				  System.out.println("emailId:   "); 
				  int emailId=sc.nextInt();
				 
			    
			    System.out.println("Receiver:   ");
			    String receiver=sc.next();
			    boolean result1=isValidReceiver(receiver);
			    if(!result1) {
			    	System.out.println("emailid validation is failed please enter correct emailId ");
			    	receiver=sc.next();
			    }
			    
			    try {
			    System.out.println("sender:   ");
			    String sender=sc.next(emailAddress);
			    	//sender=sc.next(emailAddress);
			    }catch(Exception e) {
			    System.out.println("exception:"+e.getMessage());
			    System.out.println("Email address doesn't match with the logged email Address");
			   //emailAddress=sc.next(emailAddress);
			  //  System.out.println("   ");
			    }
			    
			  System.out.println("subject:" );
			  sc.nextLine();
			  String subject=sc.nextLine();
			  
			    System.out.println("body:");
			 //   sc.nextLine();
			  String body=sc.nextLine();
			  
		// System.out.println("body:"+body);
			  User user = new User(emailId,receiver,emailAddress,subject,body);
			 
				try {
					menu.composeEmail(user);
				}catch(SQLException e) {
					System.out.println("Email sent: "+e.getMessage());
				}
			  
			  break;
				
			case 2:
			
				try {
					menu.displayEmailDetails();
				} catch (SQLException e) {
					System.out.println("All Emails-->"+e.getMessage());
				}
					break;
			
				
			case 3:
				System.out.println("deleting an email");
				try {
					menu.displayEmailDetails();
				} catch (SQLException e) {
					System.out.println("All Emails-->"+e.getMessage());
				}
				System.out.println("Enter the EmailId you want to delete");
				int emailId1=sc.nextInt();
				System.out.println("Are you sure...you want to delete(y/n)");
				char ch2=sc.next().charAt(0);
				if(ch2=='y'||ch2=='Y') { 
					try {
						menu.deleteEmailByEmailId(emailId1);
				System.out.println("------Email Deleted Sucessfully--------");
				
			}catch(SQLException e){
				System.out.println("Deleting EmailId--->"+e.getMessage());
			
				}
					break;
				}
				
				/*
				 * System.out.println("Enter the RollNo you want to delete"); int
				 * rno2=scanner.nextInt(); Student dStudent=new Student();
				 * System.out.println("Are you sure...you want to delete(y/n)"); char
				 * ch1=scanner.next().charAt(0); if(ch1=='y'||ch1=='Y') { try {
				 * sinterface.deleteStudent(rno2); System.out.println("Delete Sucessfully");
				 * }catch(SQLException e){
				 * System.out.println("Deleting student--->"+e.getMessage()); } } break;
				 */
			
			case 4:
				  System.out.println("Enter your choice for finding email data");
				  System.out.println("----------------------------------------------------------------------------");
					System.out.println("1.search by receiver \n2.search by sender \n 3.search by emailId");
					  System.out.println("----------------------------------------------------------------------------");

					System.out.println("enter your choice:");
					int value=sc.nextInt();
					switch(value)
				{
					case 1:
						System.out.println("enter the receiver emailAddress");
						receiver=sc.next();
						 menu.searchEmailByReceiver(receiver);
						break;
					case 2:
						System.out.println("enter the sender emailAddress");
						emailAddress=sc.next();
						menu.searchEmailBySender(emailAddress);
						break;
					case 3:
						System.out.println("enter the emailId to search");
						emailId=sc.nextInt();
						menu.searchEmailByEmailId(emailId);
						break;
						
					}
					
			            break;
			
			case 5:
				System.out.println("logout succesfully");
				System.out.println("  ");
				System.out.println("*****************************************************************************");
				System.out.println(" ");
				System.out.println("                Thank You For Using This Email Application..:)              ");
				System.out.println("  ");
				System.out.println("*****************************************************************************");

				System.exit(0);
				break;
				
			}	
			System.out.println("do you wish to continue say yes");
			ch1=sc.next().charAt(0);
			}while(ch1=='y' || ch1=='Y');
	break;
	}
		System.out.println("do you wish to continue say yes");
		ch=sc.next().charAt(0);
		}while(ch=='y' || ch=='Y');
	
	
	}

	
	}
	
	