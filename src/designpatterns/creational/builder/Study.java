package designpatterns.creational.builder;

/**
 * Created by viagrawal on 6/10/17.
 */
public class Study
{
	private String test;
	private String anotherTest;

	private Study(final StudyBuilder studyBuilder)
	{
		this.test = studyBuilder.test;
		this.anotherTest = studyBuilder.anotherTest;
	}

	public String getTest()
	{
		return test;
	}

	public String getAnotherTest()
	{
		return anotherTest;
	}

	public static class StudyBuilder
	{
		private String test;
		private String anotherTest;

		public StudyBuilder test(final String test)
		{
			this.test = test;
			return this;
		}

		public StudyBuilder anotherTest(final String anotherTest)
		{
			this.anotherTest = anotherTest;
			return this;
		}

		public Study build()
		{
			return new Study(this);
		}
	}

}
