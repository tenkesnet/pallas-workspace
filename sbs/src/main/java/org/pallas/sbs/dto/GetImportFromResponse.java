package org.pallas.sbs.dto;

import java.util.ArrayList;

import org.pallas.sbs.domain.User;

public class GetImportFromResponse {
	
	public boolean isValid = true;
	public String ErrorMessage;
	public ArrayList<User> users = new ArrayList<User>();
}
