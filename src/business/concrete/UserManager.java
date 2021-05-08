package business.concrete;

import business.abstracts.AuthService;
import business.abstracts.UserActivationService;
import business.abstracts.UserCheckService;
import business.abstracts.UserValidationService;
import core.abstracts.Result;
import core.abstracts.services.MailService;
import core.uilts.consts.ValidationMessages;
import entities.User;
import entities.UserActivitation;
import dataAccess.abstracts.UserDao;
public class UserManager extends AuthService {

	private UserDao userDao;
	private UserCheckService userCheckService;
	private UserValidationService userValidationService;
	private MailService mailService;
	private UserActivationService userActivationService;

	public UserManager(UserCheckService userCheckService, UserDao userDao,
			UserValidationService userValidationService, MailService mailService,
			UserActivationService userActivationService) {
		this.userCheckService = userCheckService;
		this.userDao = userDao;
		this.mailService = mailService;
		this.userValidationService = userValidationService;
		this.userActivationService = userActivationService;
	}

	@Override
	public void login(String email, String password) throws Exception {
		try {
			if (this.userDao.get(x -> x.getEmail() == email && x.getPassword() == password) != null) {
				if (this.userDao.get(x -> x.getEmail() == email).getIsActivated() == false) {
					System.out.println(ValidationMessages.userAccounNeedsToBeActivated);
				}
				else {
				System.out.println(ValidationMessages.userLoggedIn);
			}
				}

		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public void register(User user) throws Exception {
		try {
			this.userValidationService.validate(user);
			this.userCheckService.check(user);
			userDao.add(user);
			String ActivationCode = String.valueOf(this.userActivationService.GenerateActivationNumber());
			userActivationService.AddUserActivationCode(new UserActivitation(1, user.getId(), ActivationCode));
			Result result=mailService.SendActivationEmail(user.getEmail(), ActivationCode);
			System.out.println(result.getMessage());

		} catch (Exception e) {
			throw e;
		}

	}

	@Override
	public void activateAccount(String activationCode) throws Exception {
		try {
			Result result = this.userActivationService.ActivateAccountWithCode(activationCode);
			System.out.println(result.getMessage());
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
	}

}
