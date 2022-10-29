package myutil;

import java.util.GregorianCalendar;

public class MyCalendar extends GregorianCalendar {
    public String toString() {
        return "A dátum:" + get(YEAR)+"/"+
		           (get(MONTH)+1)+"/"+
			   get(DAY_OF_MONTH);
    } 
}
							
