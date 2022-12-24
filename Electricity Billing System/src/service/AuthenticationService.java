package service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;

import contract.IAuthenticationService;
import dependancyInjection.DI;
import electricityGUI.Login;
import models.LoginInfo;

public class AuthenticationService implements IAuthenticationService{
	public final String connexionRequest = "select * from login where username = '%s' and password = '%s' and user = '%s'";
		
	public LoginInfo authenticateUser(LoginInfo loginInfo){
		String finalConnexionRequest = String.format(connexionRequest, loginInfo.getUserLoginName(), loginInfo.getUserPassword(), loginInfo.getUserType());		
		DatabaseConnexion myConnexion = new DatabaseConnexion();
		try {
			ResultSet resultSet = DI.getRepositoryService().executeQuery(finalConnexionRequest);					
			if(resultSet.next()) {
				String meterNo = resultSet.getString("meter_no");
				loginInfo.setMeter(meterNo);
				
				return loginInfo;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

}
