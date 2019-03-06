package fr.afpa.formation.exceptions;

public class NoObjectEntityException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoObjectEntityException() {
		super("The object associated to this id don't exist");
		// TODO Auto-generated constructor stub
	}

	public NoObjectEntityException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public NoObjectEntityException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public NoObjectEntityException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public NoObjectEntityException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
