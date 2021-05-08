package business.abstracts;

import core.abstracts.Result;
import entities.UserActivitation;

public interface UserActivationService {

	int GenerateActivationNumber();
	void AddUserActivationCode(UserActivitation userActivation);
	Result ActivateAccountWithCode(String ActivationCode);
	
}
