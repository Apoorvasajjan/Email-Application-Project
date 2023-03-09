package emailpack.model;

public class User {
	private int emailId;
	private String receiver;
	  private String sender;
	  private String subject;
	  private String  body;
	public User(int emailId, String receiver, String sender, String subject, String body) {
		super();
		this.emailId = emailId;
		this.receiver = receiver;
		this.sender = sender;
		this.subject = subject;
		this.body = body;
	}
	public User() {
		// TODO Auto-generated constructor stub
	}
	public int getEmailId() {
		return emailId;
	}
	public void setEmailId(int emailId) {
		this.emailId = emailId;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	@Override
	public String toString() {
		return "User [emailId=" + emailId + ", receiver=" + receiver + ", sender=" + sender + ", subject=" + subject
				+ ", body=" + body + "]";
	}
	
}