package org.app.model;

public class LoginModel {

	private String username;
	private String password;
	private String logintype;
	public String getLogintype() {
		return logintype;
	}
	public void setLogintype(String logintype) {
		this.logintype = logintype;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String toString()
	{
		return "["+username+","+password+","+logintype+"]";
	}
	public int hashCode()
	{
		return username.length()*1000;
	}
	public boolean equals(Object obj)
	{
		LoginModel m=(LoginModel)obj;
		if(m.username.equals(this.username)&&m.password.equals(this.password)&&m.logintype.equals(this.logintype))
			return true;
		
		return false;
	}
}
