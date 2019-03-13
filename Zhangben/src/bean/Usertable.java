package bean;

public class Usertable {

	int id;
	String username;
	String pwd;
	String mail;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	public Usertable(){}
	
	public Usertable(String username,String pwd,String mail)
	{
		this.username = username;
		this.pwd = pwd;
		this.mail = mail;
	}
	
	public Usertable(String username,String pwd)
	{
		this.username = username;
		this.pwd = pwd;
	}
}
