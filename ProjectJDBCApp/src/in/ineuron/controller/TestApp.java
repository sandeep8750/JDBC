package in.ineuron.controller;

import java.util.Scanner;

import in.ineuron.dto.Student;
import in.ineuron.service.IStudentService;
import in.ineuron.servicefactory.StudentServiceFactory;

//controller logic
public class TestApp {

	public static void main(String[] args) {
	
		Scanner input = new Scanner(System.in);
		System.out.println("Enter student id to be deletion....");
		int sid = input.nextInt();
		
		IStudentService  studentService =  StudentServiceFactory.getStudentService();
		String message = studentService.deleteStudent(sid);
		
		if(message.equalsIgnoreCase("success"))
		{
			System.out.println("record deleted successfully....");
		}
		else if(message.equalsIgnoreCase("not found")){

			System.out.println("record not found....");
		}
		else {
			System.out.println("record not deleted successfully....");
		}
	}
	
	private static void selectionOperation() {
		
		Scanner input = new Scanner(System.in);
		IStudentService studentService = StudentServiceFactory.getStudentService();
		
		System.out.println("Enter Student id ::");
		int sid = input.nextInt();
		Student std = studentService.searchStudent(sid);
		
		if (std != null) {
			System.out.println(std);
			System.out.println("Id \t Name \t Age \t Adress \t Gender");
			
			System.out.println(std.getSid() + "\t " + std.getSname() + "\t " + std.getSage() + "\t " + std.getSaddress() + "\t " + std.getSgender() );
		}
	}
	
	private static void InsertOperation() {
		IStudentService studentService = StudentServiceFactory.getStudentService();

		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter the student name :: ");
		String sname = scanner.next();

		System.out.print("Enter the student age :: ");
		int sage = scanner.nextInt();

		System.out.print("Enter the student addres :: ");
		String saddress = scanner.next();
		
		System.out.print("Enter the student gender :: ");
		String sgender = scanner.next();

		String msg = studentService.addStudent(sname, sage, saddress , sgender);
		
		if (msg.equalsIgnoreCase("success")) {
			System.out.println("record inserted succesfully");
		} else {
			System.out.println("record insertion failed....");
		}

		scanner.close();
	}

}
