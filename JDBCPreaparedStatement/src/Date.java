
public class Date {
	public static void main(String[] args) {
		
		java.util.Date uDate = new java.util.Date();
		System.out.println(uDate);
		
		long l = uDate.getTime();
		
		java.sql.Date  sqldate = new java.sql.Date(l);
		System.out.println(sqldate);
	}
}
