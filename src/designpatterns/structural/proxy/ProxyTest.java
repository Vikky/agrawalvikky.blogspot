package designpatterns.structural.proxy;

/**
 * Created by viagrawal on 6/10/17.
 */
public class ProxyTest
{
	public static void main(String[] args) throws Exception
	{
		final CommandExecutor adminExecutor = new CommandExecutorProxy("admin", "admin");
		adminExecutor.execute("rm -rf .");

		final CommandExecutor nonAdminExecutor = new CommandExecutorProxy("user", "pwd");
		nonAdminExecutor.execute("ls -ltr");
		Thread.sleep(200);
		nonAdminExecutor.execute("rm -rf .");
	}
}
