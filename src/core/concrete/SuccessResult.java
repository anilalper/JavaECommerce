package core.concrete;

public class SuccessResult extends ResultImp{

	public SuccessResult() {
		super(true);
	}

	public SuccessResult(String message) {
		super(true, message);
	}

}