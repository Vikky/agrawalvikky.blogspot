import java.util.Date;


public final class Immutables {

	/**
	 * @param args
	 */
	final Date date=null;
	
	Immutables(){
			
	}
	
	public Date getDate(){
		Date d= new Date(this.date.getTime());
		return d;
	}
	
	public static void main(String[] args) {
			
	}

}
