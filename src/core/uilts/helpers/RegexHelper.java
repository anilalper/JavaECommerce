package core.uilts.helpers;

import java.util.regex.Pattern;

public class RegexHelper {
	
	public static boolean isEmailValid(String emailInput) {
        final String emailRegex = "^[A-Z0-9.%+-]+@[A-Z0-9.-]+.(com|org|net|edu|gov|mil|biz|info|mobi)(.[A-Z]{2})?$";
        Pattern pattern = Pattern.compile(emailRegex, Pattern.CASE_INSENSITIVE);
        return pattern.matcher(emailInput).find();
    }
}
