import java.sql.Date;

public class TestApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		java.util.Date date = new java.util.Date();
		System.out.println("util package  date is ::" + date);
		
		 long l =  date.getTime();
		
		java.sql.Date sqlDate = new Date(l);
		
		System.out.println("sql package date is :: " + sqlDate);
	}

}
