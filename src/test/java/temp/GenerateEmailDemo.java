package temp;

import java.util.Date;

public class GenerateEmailDemo {

	public static void main(String[] args) {

		Date date=new Date();
		//System.out.println(date);
		String dateString= date.toString();
		String noSpaceDateString=dateString.replaceAll("\\s", "");
		//System.out.println(noSpaceDateString);
		String noSpaceandNoColons = noSpaceDateString.replaceAll("\\:", "");
		//System.out.println(noSpaceandNoColons);
		String emailWithTimeStamp= noSpaceandNoColons + "@gmail.com";
		System.out.println(emailWithTimeStamp);

	}

}
