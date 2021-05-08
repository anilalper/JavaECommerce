package core.uilts.helpers;

import java.util.ArrayList;
import java.util.List;

import core.abstracts.Result;

public class ValidationHelper {

	public static Result[] Validator(Result... results) {
		List<Result> resultList = new ArrayList<Result>();
		for (Result result : results) {
			if(!result.isSuccess()) {
				resultList.add(result);
			}
		}
		return resultList.toArray(new Result[resultList.size()]);
	}
	
	public static Result[] Checker(Result... results) {
		return Validator(results);
	}
}
