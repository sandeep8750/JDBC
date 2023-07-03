package in.ineuron.servicefactory;

import in.ineuron.service.IStudentservice;
import in.ineuron.service.StudentServiceImpl;

public class StudentServicefactory {

	private StudentServicefactory() {
	
	}
	private static IStudentservice studentservice = null;
	public static IStudentservice getStudentService() {
		if (studentservice == null) {
			 studentservice  = new StudentServiceImpl();			
		}
		
		return studentservice;
	}
}
