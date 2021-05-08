package business.abstracts;

import core.abstracts.BaseService;
import entities.User;

public interface UserCheckService {
	public void check(User user) throws Exception;
}
