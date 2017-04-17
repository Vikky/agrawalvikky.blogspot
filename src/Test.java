import java.math.BigDecimal;

import org.joda.time.Days;
import org.joda.time.LocalDateTime;


public class Test{
	
	public static void main(String[] ar){
	
		final LocalDateTime dateBegin = LocalDateTime.parse("2016-11-02");
		final LocalDateTime dateEnd = LocalDateTime.parse("2016-10-28");
		int days = Days.daysBetween(dateBegin, dateEnd).getDays();
		System.out.println("days count : " +days);
		
		BigDecimal bd = new BigDecimal("0.010");
		System.out.println("long value : "+bd.longValue());
		
		System.out.println("A9a989".matches("[\\p{IsAlphabetic}\\p{IsDigit}]+$"));
	}
	
}
