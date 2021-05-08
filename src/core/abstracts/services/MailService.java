package core.abstracts.services;

import core.abstracts.Result;

public interface MailService {

	public Result SendActivationEmail(String to,String activationCode);
}
