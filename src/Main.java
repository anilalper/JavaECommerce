import adapters.GoogleSignUpManagerAdapter;
import business.abstracts.AuthService;
import business.abstracts.UserActivationService;
import business.abstracts.UserCheckService;
import business.abstracts.UserValidationService;
import business.concrete.UserActivationManager;
import business.concrete.UserCheckManager;
import business.concrete.UserManager;
import business.concrete.UserValidationManager;
import core.abstracts.Result;
import core.abstracts.services.MailService;
import core.concrete.services.EmailService;
import dataAccess.abstracts.UserActivitationDao;
import dataAccess.abstracts.UserDao;
import dataAccess.concrete.InMemoryUserActivitationDao;
import dataAccess.concrete.InMemoryUserDao;
import entities.EmailList;
import entities.User;

public class Main {

	public static void main(String[] args) throws Exception {
		UserDao userDao = new InMemoryUserDao();
		UserValidationService userValidationService = new UserValidationManager();
		UserActivitationDao userActivationDao = new InMemoryUserActivitationDao();
		MailService mailService = new EmailService();
		
		UserActivationService userActivationService = new UserActivationManager(userActivationDao,userDao);
	    UserCheckService userCheckService=new UserCheckManager(userDao);	
		AuthService authService=new UserManager(userCheckService,userDao,userValidationService,mailService,userActivationService);
		
		User user=new User(1,"alperavdan@gmail.com","123456","Alper","Avdan");
//		User user2=new User(2,"alperavdan@gmail.com","1234567","Alper","Avdan");
//		
		authService.register(user);
//		
		 Result result=userActivationService.ActivateAccountWithCode("55001");
		System.out.println(result.getMessage());
		authService.login("alperavdan@gmail.com", "123456");
//		authService.register(user2);
		
//		GoogleSignUpManagerAdapter  googleSignUp=new GoogleSignUpManagerAdapter(authService); 
//		googleSignUp.register(user);
	
	}

}
