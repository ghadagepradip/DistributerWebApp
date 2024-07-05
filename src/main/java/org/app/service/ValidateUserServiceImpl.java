package org.app.service;

import org.app.model.LoginModel;
import org.app.repository.ValidateUserRepositoryImpl;

public class ValidateUserServiceImpl implements ValidateUserService {

	ValidateUserRepositoryImpl vrepo=new ValidateUserRepositoryImpl();
	public LoginModel isValidate(LoginModel	model)
	{
		return vrepo.isValidate(model);
	}
}
