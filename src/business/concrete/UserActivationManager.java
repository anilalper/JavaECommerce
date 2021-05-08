package business.concrete;

import java.util.Random;

import business.abstracts.UserActivationService;
import core.abstracts.Result;
import core.concrete.ErrorResult;
import core.concrete.SuccessResult;
import core.uilts.consts.ValidationMessages;
import dataAccess.abstracts.UserActivitationDao;
import dataAccess.abstracts.UserDao;
import entities.User;
import entities.UserActivitation;

public class UserActivationManager implements UserActivationService {

	private UserActivitationDao userActivitionDao;
	private UserDao userDao;
	public UserActivationManager(UserActivitationDao userActivitionDao,UserDao userDao) {
		this.userActivitionDao = userActivitionDao;
		this.userDao=userDao;
	}

	
	@Override
	public int GenerateActivationNumber() {
		/*
		 * Random random = new Random(); return
		 * random.nextInt(options.numberGeneratorUpperBound);
		 */
		return 55001;
	}

	@Override
	public void AddUserActivationCode(UserActivitation userActivation) {
		this.userActivitionDao.add(userActivation);
		System.out.println("User Activation Added...");
		
	}


	@Override
	public Result ActivateAccountWithCode(String activationCode) {
		if(userActivitionDao.get(x->x.getActivationCode().equals(activationCode))==null) {
		
			return new ErrorResult(ValidationMessages.activationCodeNotFound);
		}
		else {
			int userId=userActivitionDao.get(x->x.getActivationCode().equals(activationCode)).getUserId();
			User user=userDao.get(x->x.getId()==userId);
			user.setIsActivated(true);
			userDao.update(user);
			return new SuccessResult(ValidationMessages.userActivated);
		}
		
	}

}
