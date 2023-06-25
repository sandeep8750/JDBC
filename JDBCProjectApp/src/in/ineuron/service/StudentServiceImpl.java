package in.ineuron.service;

import in.ineuron.daofactory.StudentDaoFactory;
import in.ineuron.dto.Student;
import in.ineuron.persistence.IStudentDao;

public class StudentServiceImpl implements IStudentservice {

	@Override
	public String addStudent(String sname, Integer sage, String saddress) 
	{
		IStudentDao studentDao = StudentDaoFactory.getStudentDao();
		return studentDao.addStudent(sname, sage, saddress);
	}

	@Override
	public Student searchStudent(Integer sid) {
		IStudentDao studentDao = StudentDaoFactory.getStudentDao();
		Student searchStudent = studentDao.searchStudent(sid);
		return searchStudent;
	}

	@Override
	public String updateStudent(Integer sid, String sname, Integer sage, String saddress) {
		IStudentDao studentDao = StudentDaoFactory.getStudentDao();
		String updateStudent = studentDao.updateStudent(sid, sname, sage, saddress);
		return updateStudent;
	}

	@Override
	public String deleteStudent(Integer sid) {

		IStudentDao studentDao = StudentDaoFactory.getStudentDao();
		String deleteStudent = studentDao.deleteStudent(sid);
		return deleteStudent;
	}

}
