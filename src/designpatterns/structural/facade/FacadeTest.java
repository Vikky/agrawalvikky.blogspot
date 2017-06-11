package designpatterns.structural.facade;

/**
 * Created by viagrawal on 6/10/17.
 */
public class FacadeTest
{

	public static void main(String[] args)
	{
		final ComputerFacade computerFacade = new ComputerFacade(new CPU(new Memory()), new HDD());
		computerFacade.start();
	}
}
