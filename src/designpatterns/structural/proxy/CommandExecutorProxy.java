package designpatterns.structural.proxy;

/**
 * Created by viagrawal on 6/10/17.
 */
public class CommandExecutorProxy implements CommandExecutor
{

	private boolean isAdmin;
	private CommandExecutor executor;

	public CommandExecutorProxy(String user, String pwd)
	{
		if ("admin".equals(user) && "admin".equals(pwd))
		{
			isAdmin = true;
		}
		executor = new CommandExecutorImpl();
	}

	@Override
	public void execute(final String cmd)
	{
		if (!isAdmin && (cmd.startsWith("rm") || cmd.startsWith("del")))
		{
			throw new RuntimeException("these commands not allowed for non admin users");
		}
		executor.execute(cmd);
	}
}
