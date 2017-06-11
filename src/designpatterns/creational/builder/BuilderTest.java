package designpatterns.creational.builder;

/**
 * Created by viagrawal on 6/10/17.
 */
public class BuilderTest
{
	public static void main(String[] args)
	{
		final Study study = new Study.StudyBuilder()
				.test("testString")
				.anotherTest("anothertestString")
				.build();
		System.out.println(study.getTest());
		System.out.println(study.getAnotherTest());
	}
}
