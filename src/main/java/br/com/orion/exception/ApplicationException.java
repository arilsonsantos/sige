package br.com.orion.exception;

import lombok.Getter;
import lombok.Setter;

public class ApplicationException extends RuntimeException {

	private static final long serialVersionUID = -8074972537325278159L;

	@Getter
	@Setter
	private String clientId;

	public ApplicationException() {
		super();
	}

	public ApplicationException(String message) {
		super(message);
	}

	public ApplicationException(Throwable cause) {
		super(cause);
	}

}