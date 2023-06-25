package in.ineuron.controller;

import in.ineuron.service.IStudentService;
import in.ineuron.servicefactroy.StudentServiceFactory;

public class TestApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		IStudentService studentService  =  StudentServiceFactory.getStudentService();
	}

}
