package business.abstracts;



public abstract class AuthService extends SignUpService{

	//public void register(User user) throws Exception{};
	public void login(String email,String password) throws Exception{};
	public void activateAccount(String activationCode) throws Exception{};


}
