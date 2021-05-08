package business.concrete;

import business.abstracts.UserValidationService;
import core.abstracts.Result;
import core.concrete.ErrorResult;
import core.concrete.SuccessResult;
import entities.User;
import core.uilts.consts.ValidationMessages;
import core.uilts.consts.options;
import core.uilts.helpers.RegexHelper;
import core.uilts.helpers.ValidationHelper;


public class UserValidationManager implements UserValidationService{

	 public UserValidationManager() {
		// TODO Auto-generated constructor stub
	};
	@Override
	public void validate(User user) throws Exception{
	
      Result[] results = ValidationHelper.Checker(this.checkPasswordDigits(user.getPassword()),
    		  this.checkPasswordisNull(user.getPassword()),
    				  this.isEmailNotNull(user.getEmail()),
    				  this.isValidEmail(user.getEmail()),
    				  this.isFirstNameValid(user.getName()),
    				  this.isLastNameValid(user.getLastName()));
		
		for (Result result : results) {
			if (!result.isSuccess()) {
				throw new Exception(result.getMessage());
			}
		}
	}
		
	
	
	private Result checkPasswordisNull(String password) {
        if (password==null) {
			return new ErrorResult(ValidationMessages.passwordCanNotBeNullOrEmpty);
		}	
        return new SuccessResult();
		
	}
	
	private Result checkPasswordDigits(String password) {
         if (password.length()<options.passwordDigitStrength) {
			return new ErrorResult(ValidationMessages.passwordLeastCharacter.replace("[x]",String.valueOf(options.passwordDigitStrength)));
		}	
         return new SuccessResult();
		
	}
	
	private Result isValidEmail(String email) {
        if (!RegexHelper.isEmailValid(email)) {
			return new ErrorResult(ValidationMessages.emailNotValid);
		}	
        return new SuccessResult();
		
	}
	
	private Result isEmailNotNull(String email) {
        if (email.isEmpty()||email.isBlank()) {
			return new ErrorResult(ValidationMessages.emailCanNotBeNullOrEmpty);
		}	
        return new SuccessResult();
		
	}
	
	private Result isFirstNameValid(String name) {
	    if (name.length()<options.minimumNameStrength) {
				return new ErrorResult(ValidationMessages.firstNameLeastCharacter.replace("[x]",String.valueOf(options.minimumNameStrength)));
			}	
	        return new SuccessResult();
			
		}
	private Result isLastNameValid(String lastName) {
	    if (lastName.length()<options.minimumLastNameStrength) {
				return new ErrorResult(ValidationMessages.lastNameLeastCharacter.replace("[x]",String.valueOf(options.minimumLastNameStrength)));
			}	
	        return new SuccessResult();
			
		}

	

}
