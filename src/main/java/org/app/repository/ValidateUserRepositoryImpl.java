package org.app.repository;

import org.app.model.LoginModel;

public class ValidateUserRepositoryImpl extends DBParent implements ValidateUserRepository {

	public LoginModel isValidate(LoginModel	model)
	{
		try
		{
			stmt=conn.prepareStatement("select * from login where username=? and password=?;");
			stmt.setString(1,model.getUsername());
			stmt.setString(2,model.getPassword());
			rs=stmt.executeQuery();
			if(rs.next())
			{
				model.setLogintype(rs.getString("logintype"));
			}
			return model;
		}
		catch(Exception e)
		{
			System.out.println("Error is "+e);
			return null;
		}
	}
	public static void main(String args[])
	{
		ValidateUserRepositoryImpl v=new ValidateUserRepositoryImpl();
		LoginModel model=new LoginModel();
		model.setUsername("abc");
		model.setPassword("abc");
		model=v.isValidate(model);
		System.out.println(model);
		
	}
}
