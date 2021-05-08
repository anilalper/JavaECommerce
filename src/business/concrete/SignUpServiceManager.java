package business.concrete;

import business.abstracts.AuthService;
import business.abstracts.SignUpService;
import entities.User;

public abstract class SignUpServiceManager extends SignUpService{

	private AuthService authService;
	
	public SignUpServiceManager(AuthService authService) {
		this.authService=authService;
	}
	
	@Override
	public void register(User user) throws Exception {
		this.authService.register(user);
	}
}
