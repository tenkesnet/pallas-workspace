package org.pallas.sbs.domain;

import java.util.Date;


import org.springframework.stereotype.Component;


@Component
public class User {
	public String Name;
	public String MotherName;
	public String Location;
	public Date BirthDate;
	
	public User() {}
	
	public User(String name,String motherName,String location, Date birthDate ) {
		Name = name;
		MotherName = motherName;
		Location = location;
		BirthDate = birthDate;
	}
}
