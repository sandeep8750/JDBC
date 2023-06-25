import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class DateConversion {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("Enter date any format :: (dd-mm-yyyy)");
		String inputedate = input.next();
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		java.util.Date udate = sdf.parse(inputedate);
		
		long l = udate.getTime();
		
		java.sql.Date sqldate = new  java.sql.Date(l);
		

		System.out.println("inputed date is :: " + inputedate);
		System.out.println("util  date is :: " + udate);
		System.out.println("sql date is :: " + sqldate);
		
		//If inputed date is same as mysql database then no need to conversion 
		System.out.println("Input Date again :: ");
		String  date = input.next();
		java.sql.Date sDate = sqldate.valueOf(date);
		System.out.println(sDate);
	}

}
