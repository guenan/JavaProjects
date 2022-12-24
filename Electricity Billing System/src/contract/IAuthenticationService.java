package contract;

import models.LoginInfo;

public interface IAuthenticationService {
	
	public LoginInfo authenticateUser(LoginInfo login);
}
