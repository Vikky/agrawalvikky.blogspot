package designpatterns.structural.facade;

/**
 * Created by viagrawal on 6/10/17.
 */
public class CPU
{
	private Memory memory;

	public CPU(final Memory memory)
	{
		this.memory = memory;
	}

	public void start()
	{
		memory.loadRam();
		System.out.println("Initiating CPU");
	}

	public void execute(final String cmd)
	{
		System.out.println("Executing command " + cmd);
	}

}
