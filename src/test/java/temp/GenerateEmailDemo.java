package temp;

import java.util.Date;

public class GenerateEmailDemo {

	public static void main(String[] args) {

       Date date=new Date();
        System.out.println(date);
       String dateInStringFormat=date.toString();
        System.out.println(dateInStringFormat);
        String dateWithoutSpaces=dateInStringFormat.replaceAll("\\s","");
        System.out.println(dateWithoutSpaces);
        String dateWithoutTimeStamp=dateWithoutSpaces.replaceAll("\\:","");
       String emailGenerated=dateWithoutTimeStamp + "@gmail.com";
        System.out.println(emailGenerated);



	}

}
