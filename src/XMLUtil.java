/**
 * XMLUtil.java
 *
 */

/**
 * @author viagrawal
 *
 */

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;

public class XMLUtil {

	public static void main(String[] args) throws IOException {

		File insertFile = new File(
				"/Users/viagrawal/git/learnjava/src/test.xml");
		function(insertFile);

		// String content = new
		// String(Files.readAllBytes(Paths.get("/Users/viagrawal/git/learnjava/src/test.xml")));
		// StringBuffer sb = new StringBuffer(content.length());
		// System.out.println("Conetent is : "+content);
		//
		//
		// // content.replaceAll("<entry key=\"InsertItinerary1\"", "");
		// //
		// // System.out.println("Content after replace " +content);
		//
		// Pattern p = Pattern.compile("<entry key=\"InsertItinerary1\"");
		//
		//
		// Matcher matcher = p.matcher(content);
		//
		// while (matcher.find()) {
		// System.out.print("Start index: " + matcher.start());
		// System.out.print(" End index: " + matcher.end() + " ");
		// System.out.println(matcher.group());
		// matcher.replaceAll("");
		// }
		//
		// System.out.println("Content after replace " +matcher.group());
		//
	}

	public static void function(File dbFile) throws IOException {

		
		Pattern InsertTraveler = Pattern.compile("<entry key=\"InsertTraveler[0-9]*\"([\\s]*[\\n]*)");
		Pattern InsertTravelerAccount = Pattern.compile("<entry key=\"InsertTravelerAccount[0-9]*\"([\\s]*[\\n]*)");
		Pattern InsertItinerary = Pattern.compile("<entry key=\"InsertItinerary[0-9]*\"([\\s]*value=\"\")");
		
		

		List<String> readLines = FileUtils.readLines(dbFile);
		List<String> outlines = new ArrayList<String>();
		List<String> outlines2 = new ArrayList<String>();
		boolean flag = false;

		for(String line : readLines) {
			if(line.trim().matches("<entry key=\"InsertTraveler[0-9]*\">") 
					|| line.trim().matches("<entry key=\"InsertTravelerAccount[0-9]*\">")
					|| line.trim().matches("<entry key=\"InsertTraveler[0-9]*\" >") 
					|| line.trim().matches("<entry key=\"InsertTravelerAccount[0-9]*\" >")
					|| line.trim().matches("<entry key=\"InsertItinerary[0-9]*\"")
					) {
				flag=true;
				
			} else if (flag && line.trim().endsWith("</entry>")) {
				flag = false;
			} else if (!flag) {
				outlines.add(line);
				flag=false;
			}
		}
		
		for(String line : outlines) {
			if(			line.trim().matches("<entry key=\"InsertTraveler[0-9]*\"") 
					|| 	line.trim().matches("<entry key=\"InsertTravelerAccount[0-9]*\"") 
					||  line.trim().matches("<entry key=\"InsertItinerary[0-9]*\"([\\s]*value=\"\")")) {
				flag=true;
				if(line.trim().endsWith("/>")) {
					flag=false;
				}
			} else if (flag && line.trim().endsWith("/>")) {
				flag = false;
			} else if (!flag) {
				outlines2.add(line);
				flag=false;
			}
		}
		FileUtils.writeLines(dbFile, outlines2, "\n");

	}

}
