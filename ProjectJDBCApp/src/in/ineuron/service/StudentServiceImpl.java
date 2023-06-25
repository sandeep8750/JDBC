package in.ineuron.service;

import in.ineuron.daofactory.StudentDaoFactory;
import in.ineuron.dto.Student;
import in.ineuron.persistence.IStudentDao;
import in.ineuron.persistence.StudentDaoImpl;

//service layer logic
public class StudentServiceImpl implements IStudentService {

	private IStudentDao stdDao;

	public String addStudent(String sname, Integer sage, String saddress , String sgender) {
		stdDao = StudentDaoFactory.getStudentDao();
		return stdDao.addStudent(sname, sage, saddress , sgender);
	}

	@Override
	public Student searchStudent(Integer sid) {
		IStudentDao studentDao = StudentDaoFactory.getStudentDao();
		return studentDao.searchStudent(sid);
	}

	@Override
	public String deleteStudent(Integer sid) {
		IStudentDao studentDao = StudentDaoFactory.getStudentDao();
		return  studentDao.deleteStudent(sid);
		
	}

	@Override
	public String updateStudent(Integer sid, String sname, Integer sage, String saddress) {
		return null;
	}


	
}


