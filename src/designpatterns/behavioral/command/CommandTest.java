package designpatterns.behavioral.command;

/**
 * Created by viagrawal on 6/11/17.
 */
public class CommandTest
{
	public static void main(String[] args)
	{
		final Command video3GP = new Play3GP();
		final Command videoMP3 = new PlayMP3();
		final Command videoMP4 = new PlayMP4();

		CommandInvoker commandInvoker = new CommandInvoker(video3GP);
		commandInvoker.invoke();

		commandInvoker.setCommand(videoMP3);
		commandInvoker.invoke();

		commandInvoker.setCommand(videoMP4);
		commandInvoker.invoke();
	}

}
