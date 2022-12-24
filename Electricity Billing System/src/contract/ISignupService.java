package contract;

import models.LoginInfo;

public interface ISignupService {

	/**
	 * Use this method to create user login account
	 * @param loginInfo: contains information about account to create
	 */
	public int createLoginInfo(LoginInfo loginInfo);
	
	/**
	 * Use this method to update user login account
	 * @param loginInfo: contains information about updated account 
	 */
	public int updateLoginInfo(LoginInfo loginInfo);
}
