package designpatterns.structural.facade;

/**
 * Created by viagrawal on 6/10/17.
 */
public class ComputerFacade
{
	private CPU cpu;
	private HDD hdd;

	public ComputerFacade(final CPU cpu, final HDD hdd)
	{
		this.cpu = cpu;
		this.hdd = hdd;
	}

	public void start()
	{
		cpu.start();
		hdd.initializeHardDrive();
		cpu.execute("Show desktop");
	}

}
