package com.guimcarneiro.fightclub.domain.exception;

public class BusinessException extends RuntimeException {

	private static final long serialVersionUID = -4658100342374089508L;

	public BusinessException(String message) {
		super(message);
	}
	
}
