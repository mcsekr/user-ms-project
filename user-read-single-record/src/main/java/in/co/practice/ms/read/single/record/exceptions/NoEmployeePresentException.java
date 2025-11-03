package in.co.practice.ms.read.single.record.exceptions;

public class NoEmployeePresentException extends Exception {

	private static final long serialVersionUID = -8908308352399017423L;
	private String message;

	public NoEmployeePresentException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
