package business.abstracts;

import core.abstracts.BaseService;
import entities.User;

public interface UserValidationService {

	public void validate(User user)throws Exception;
}
