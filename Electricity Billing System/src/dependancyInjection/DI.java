package dependancyInjection;

import contract.IAuthenticationService;
import contract.IRepository;
import contract.ISignupService;
import service.AuthenticationService;
import service.Repository;
import service.SignupService;

public class DI {

	private static IRepository repositoryService = new Repository();
	private static IAuthenticationService authenticationService = new AuthenticationService();
	private static ISignupService signupService = new SignupService();
	
	
	public static IRepository getRepositoryService() {
		return repositoryService;
	}
	
	public static IRepository getNewInstanceRepositoryService() {
		return new Repository();
	}
	
	public static IAuthenticationService getAuthenticationService() {
		return authenticationService;
	}
	
	public static IAuthenticationService getNewInstanceAuthenticationService() {
		return new AuthenticationService();
	}
	
	public static ISignupService getSignupService() {
		return signupService;
	}
	
	public static ISignupService getNewInstanceSignupService() {
		return new SignupService();
	}
}
