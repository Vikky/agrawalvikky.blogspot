package designpatterns.behavioral.command;

/**
 * Created by viagrawal on 6/11/17.
 */
public class PlayMP3 implements Command
{
	@Override
	public void execute()
	{
		System.out.println("playing mp3");
	}
}
