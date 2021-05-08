package adapters;

import business.abstracts.AuthService;
import business.concrete.SignUpServiceManager;
import core.uilts.consts.ValidationMessages;

import entities.User;
import googleExternalService.GoogleSignUpManager;

public class GoogleSignUpManagerAdapter extends SignUpServiceManager{

	public GoogleSignUpManagerAdapter(AuthService authService) {
		super(authService);
	}	
	@Override
	public void register(User user) throws Exception {
		GoogleSignUpManager googleSignUpManager = new GoogleSignUpManager();
		boolean result = googleSignUpManager.login(user.getEmail());
		if(result) {
			super.register(user);
			System.out.println(ValidationMessages.googleSignUpSuccessful);
		}else {
			System.out.println(ValidationMessages.googleSignUpFailed);
		}
	}

	

}
