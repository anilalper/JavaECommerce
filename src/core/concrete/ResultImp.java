package core.concrete;

import core.abstracts.Result;

public class ResultImp implements Result{

	private String message;
	private Boolean isSuccess;
	public ResultImp(Boolean isSuccess) {
		this.isSuccess=isSuccess;
	}
	public ResultImp(Boolean isSuccess,String message) {
		this(isSuccess);
		this.message = message;
	}


	@Override
	public Boolean isSuccess() {
		// TODO Auto-generated method stub
		return isSuccess;
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return this.message;
	}

}
