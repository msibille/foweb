package it.finsoft;

public class ReturnVO<T> {
	private String warnDesc;
	private long warnCode;
	private String infoDesc;
	private long infoCode;
	private FowebException exception;

	private T retVal;

	public String getWarnDesc() {
		return warnDesc;
	}

	public void setWarnDesc(String warnDesc) {
		this.warnDesc = warnDesc;
	}

	public long getWarnCode() {
		return warnCode;
	}

	public void setWarnCode(long warnCode) {
		this.warnCode = warnCode;
	}

	public String getInfoDesc() {
		return infoDesc;
	}

	public void setInfoDesc(String infoDesc) {
		this.infoDesc = infoDesc;
	}

	public long getInfoCode() {
		return infoCode;
	}

	public void setInfoCode(long infoCode) {
		this.infoCode = infoCode;
	}

	public T getRetVal() {
		return retVal;
	}

	public void setRetVal(T retVal) {
		this.retVal = retVal;
	}

	public FowebException getException() {
		return exception;
	}

	public void setException(FowebException exception) {
		this.exception = exception;
	}
}
