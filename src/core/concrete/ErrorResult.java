package core.concrete;



public class ErrorResult extends ResultImp{

	public ErrorResult() {
		super(false);
	}

	public ErrorResult(String message) {
		super(false, message);
	}

}
