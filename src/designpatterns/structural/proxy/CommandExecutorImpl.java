package designpatterns.structural.proxy;

/**
 * Created by viagrawal on 6/10/17.
 */
public class CommandExecutorImpl implements CommandExecutor
{
	@Override
	public void execute(final String cmd)
	{
		System.out.println(cmd + " command executed");
	}
}
