package in.ineuron.controller;

import java.util.Scanner;

import in.ineuron.dto.Student;
import in.ineuron.service.IStudentservice;
import in.ineuron.servicefactory.StudentServicefactory;

public class TestApp {

	public static void main(String[] args) {
		update();
	}

	private static void update() {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter Student data for updation....");
		System.out.println();
		System.out.println("Enter student Id :: ");
		int id = input.nextInt();
		System.out.println("Enter student Name :: ");
		String name = input.next();
		System.out.println("Enter Student Age :: ");
		int age = input.nextInt();
		System.out.println("Enter Student Adress");
		String address = input.next();
		
		IStudentservice studentService = StudentServicefactory.getStudentService();
		String updateStudent = studentService.updateStudent(id, name, age, address);
		
		if(updateStudent.equalsIgnoreCase("success"))
		{
			System.out.println("record Updated successfully.....");
		}
		else if(updateStudent.equalsIgnoreCase("not found")) {
			System.out.println("Record not found.....");
		}
	}

	private static void deleteStudent() {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter Student id :: ");
		Integer sid = input.nextInt();
		
		IStudentservice studentService = StudentServicefactory.getStudentService();
		String deletedStudent  = studentService.deleteStudent(sid);
		
		if(deletedStudent.equalsIgnoreCase("success"))
		{
			System.out.println("Record deletd successfully.....");
		}
		else if(deletedStudent.equalsIgnoreCase("not found")) {
			System.out.println(" Record not found.....");
		}
		else {
			System.out.println("Oops! something went wrong....");
		}
	}

	private static void searchStudent() {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter Student id :: ");
		Integer sid = input.nextInt();
		
		IStudentservice studentService = StudentServicefactory.getStudentService();
		Student getedStudent  = studentService.searchStudent(sid);
		
		if(getedStudent !=null) {
			
		Integer id = getedStudent.getSid();
		String name = getedStudent.getSname();
		Integer age = getedStudent.getSage();
		String address = getedStudent.getSaddress();
		System.out.println("Id" + "\t" + "Name"  + "\t" + "Age"  + "\t" + "Address");
		
		System.out.println(id + "\t" + name  + "\t" + age  + "\t" + address);
		}
		else {
			System.out.println("Record in not found for perticular student whose id is " + sid +".....");
		}
		input.close();
	}

	private static void addStudent( ) {
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter Student Name :: ");
		String sname = input.next();
		
		System.out.println("Enter Student Age :: ");
		Integer sage = input.nextInt();
		
		System.out.println("Enter Student Address :: ");
		String saddress = input.next();
		
		
		IStudentservice studentService = StudentServicefactory.getStudentService();
		String addStudent = studentService.addStudent(sname, sage, saddress);
		if(addStudent.equalsIgnoreCase("Record inserted successfully...")) {
			System.out.println("Record inserted successfully");
		}
		input.close();
	}

}
