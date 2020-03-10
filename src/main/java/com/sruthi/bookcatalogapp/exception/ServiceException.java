package com.sruthi.bookcatalogapp.exception;

@SuppressWarnings("serial")
public class ServiceException extends Exception {
	public ServiceException(String msg)
	{
		super(msg);
	}
}