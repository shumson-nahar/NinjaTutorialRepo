package showDateTimeStampCode;

import java.util.Date;

public class DateTimeStamp {
	public static void main(String[] args) {
		Date date = new Date();
		System.out.println(date.toString());
		String replacedate = date.toString().replace(" ", "_");
		System.out.println(replacedate);
		String FinalReplaceDate = replacedate.replace(":", "_");
		System.out.println(FinalReplaceDate);
	}

}
