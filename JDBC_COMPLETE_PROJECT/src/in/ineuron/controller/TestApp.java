package in.ineuron.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import in.ineuron.dto.Student;
import in.ineuron.service.IStudentservice;
import in.ineuron.servicefactory.StudentServicefactory;

public class TestApp {

	public static void main(String[] args) throws Exception {	

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {

			System.out.println("1. CREATE");
			System.out.println("2. READ");
			System.out.println("3. UPDATE");
			System.out.println("4. DELETE");
			System.out.println("5. EXIT");
			System.out.print("ENTER UR CHOICE, PRESS[1/2/3/4/5]::  ");
			String option = br.readLine();

			switch (option) {
			case "1":
				addStudent();
				break;
			case "2":
				searchStudent();
				break;
			case "3":
				update();
				break;
			case "4":
				deleteStudent();
				break;
			case "5":
				System.out.println("******* Thanks for using the application *****");
				System.exit(0);
			default:
				System.out.println("Invalid option plz try agin with valid options....");
				break;
			}

		}
}


	private static void update() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter the student id to be updated:: ");
		String sid = br.readLine();

		IStudentservice studentService = StudentServicefactory.getStudentService();
		Student student = studentService.searchStudent(Integer.parseInt(sid));

		if (student != null) {
			Student newStudent = new Student();

			System.out.println("Student id is :: " + student.getSid());
			newStudent.setSid(student.getSid());

			System.out.print("Student oldName is :: " + student.getSname() + "  Enter newName :: ");
			String newName = br.readLine();
			if (newName.equals("") || newName == "") {
				newStudent.setSname(student.getSname());
			} else {
				newStudent.setSname(newName);
			}
			System.out.print("Student oldAge is :: " + student.getSage() + "  Enter newAge :: ");
			String newAge = br.readLine();
			if (newAge.equals("") || newAge == "") {
				newStudent.setSage(student.getSage());
			} else {
				newStudent.setSage(Integer.parseInt(newAge));
			}
			System.out.print("Student oldAddress is :: " + student.getSaddress() + "  Enter newAddress :: ");
			String newAddress = br.readLine();
			if (newAddress.equals("") || newAddress == "") {
				newStudent.setSaddress(student.getSaddress());
			} else {
				newStudent.setSaddress(newAddress);
			}

			System.out.println("new Object data is :: " + newStudent);
			System.out.println();

			String status = studentService.updateStudent(newStudent);
			if (status.equalsIgnoreCase("success")) {
				System.out.println("record updated succesfully");
			} else {
				System.out.println("record updation failed");
			}

		} else {
			System.out.println("Student record not available for the given id  " + sid + " for updation...");
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
		
	}

}
