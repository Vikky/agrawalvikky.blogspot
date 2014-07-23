import java.util.Date;

/*
 Make a class immutable by following these guidelines:

1. ensure the class cannot be overridden - make the class final, or use static factories and keep constructors private
2. make fields private and final set them in constructor/static field
3. force callers to construct an object completely in a single step, instead of using a no-argument constructor combined with subsequent calls to setXXX methods (that is, avoid the Java Beans convention)
4. do not provide any methods which can change the state of the object in any way - not just setXXX methods, but any method which can change state
5. if the class has any mutable object fields, then they must be defensively copied when they pass between the class and its caller
	In Effective Java, Joshua Bloch makes this compelling recommendation :
	"Classes should be immutable unless there's a very good reason to make them mutable.
	If a class cannot be made immutable, limit its mutability as much as possible."
 * 
 */




public final class ImmutableImpl {

	//mark field variables private and final
	private final int var;	
	private final Date date;

	ImmutableImpl(int var, Date date){
		this.var=var;
		//makes it more robust if any changes made in date passed in constructor		
		this.date=new Date(date.getTime());
	}

	public int getVar() {
		return var;
	}

	//return a new Date object using present Date.
	//Makes it immutable
	public Date getDate() {
		return new Date(this.date.getTime());
	}


	//No setter methods


}
