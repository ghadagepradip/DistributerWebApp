package org.app.repository;

import org.app.model.LoginModel;

public interface ValidateUserRepository {

	public LoginModel isValidate(LoginModel	model);
}
