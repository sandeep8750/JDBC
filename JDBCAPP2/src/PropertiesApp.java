import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesApp {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileInputStream fis   = new FileInputStream("application.properties");
		Properties properties = new Properties();
		properties.load(fis);
		
		System.out.println(properties.getProperty("url"));
		System.out.println(properties.getProperty("password"));
		System.out.println(properties.getProperty("username"));
	}

}
