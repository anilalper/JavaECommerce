package core.concrete.services;

import core.abstracts.Result;
import core.abstracts.services.MailService;
import core.concrete.SuccessResult;


public class EmailService implements MailService  {

	@Override
	public Result SendActivationEmail(String to, String activationCode) {
		
		return new SuccessResult("Activation Code:"+activationCode+" sent email of"+to);
	}

}
