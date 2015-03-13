package it.finsoft;

public class FowebException extends Exception {

	private static final long serialVersionUID = -5505107726970008193L;

	private long errCode;

	public long getErrCode() {
		return errCode;
	}

	public void setErrCode(long errCode) {
		this.errCode = errCode;
	}

	public FowebException() {
		super();
	}

	public FowebException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public FowebException(String message, Throwable cause) {
		super(message, cause);
	}

	public FowebException(String message) {
		super(message);
	}

	public FowebException(String message, long errCode) {
		super(message);
		this.errCode = errCode;
	}

	public FowebException(Throwable cause) {
		super(cause);
	}

}
