package designpatterns.behavioral.command;

/**
 * Created by viagrawal on 6/11/17.
 */
public class CommandInvoker
{
	private Command command;

	public CommandInvoker(final Command command)
	{
		this.command = command;
	}

	public void invoke()
	{
		this.command.execute();
	}

	public void setCommand(final Command command)
	{
		this.command = command;
	}

}
