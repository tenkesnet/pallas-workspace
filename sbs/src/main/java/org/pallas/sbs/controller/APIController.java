package org.pallas.sbs.controller;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import org.pallas.sbs.Gyarto;
import org.pallas.sbs.Tej;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class APIController {

	@GetMapping("/kutya")
	public Tej kutya() {
		Tej mizo = new Tej();
		mizo.Name = "mizo";
		GregorianCalendar calendar = new GregorianCalendar(2022,11,29,10,30);
		calendar.setTimeZone(TimeZone.getTimeZone("CET"));
		mizo.lejaratiDatum=	calendar.getTime();
		mizo.gyarto = new Gyarto();
		mizo.gyarto.Markaname = "MIZO";
		return mizo;
	}
}
