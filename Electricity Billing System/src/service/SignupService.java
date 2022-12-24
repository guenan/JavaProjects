package service;


import contract.ISignupService;
import dependancyInjection.DI;
import models.LoginInfo;

public class SignupService implements ISignupService {

	public final String createLoginInfoRequest = "insert into login values('%s', '%s', '%s', '%s', '%s')";
	public final String updateLoginInfoRequest = "update login set username = '%s', name = '%s', password = '%s', user = '%s' where meter_no = '%s'";
	@Override
	public int createLoginInfo(LoginInfo loginInfo) {
		String finalcreateLoginInfoRequest = String.format(createLoginInfoRequest, loginInfo.getMeter(), loginInfo.getUserLoginName(), loginInfo.getUserName(), loginInfo.getUserPassword(), loginInfo.getUserType());
		return DI.getRepositoryService().executeUpdate(finalcreateLoginInfoRequest);
	}

	@Override
	public int updateLoginInfo(LoginInfo loginInfo) {
		String finalUpdateLoginInfoRequest = String.format(updateLoginInfoRequest, loginInfo.getUserLoginName(), loginInfo.getUserName(), loginInfo.getUserPassword(), loginInfo.getUserType(), loginInfo.getMeter());
		return DI.getRepositoryService().executeUpdate(finalUpdateLoginInfoRequest);
		
	}

}
