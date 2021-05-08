package business.concrete;

import business.abstracts.UserCheckService;
import core.abstracts.Result;
import core.concrete.ErrorResult;
import core.concrete.SuccessResult;
import core.uilts.consts.ValidationMessages;
import core.uilts.helpers.ValidationHelper;
import dataAccess.abstracts.UserDao;
import entities.User;

public class UserCheckManager implements UserCheckService{

	private UserDao userDao;
	public UserCheckManager() {};
	public UserCheckManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}
	
	@Override
	public void check(User user) throws Exception{
     Result[] results = ValidationHelper.Checker(this.checkEmailDuplicate(user.getEmail()));
		
		for (Result result : results) {
			if (!result.isSuccess()) {
				throw new Exception(result.getMessage());
			}
		}
	}
	
	private Result checkEmailDuplicate(String email) {
		if (this.userDao.get(x->x.getEmail()==email)!=null) {
			return new ErrorResult(ValidationMessages.emailAlreadyExists);
		}
		return new SuccessResult();
	
	};

}
