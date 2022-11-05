package kodlamaioWeb.business;

import java.util.List;

import kodlamaioWeb.core.Logger;
import kodlamaioWeb.dataAccess.InstructorDao;
import kodlamaioWeb.entities.Instructor;

public class InstructorManager {
	
	InstructorDao instructorDao;
	private List<Logger> loggers;
	
	public InstructorManager(InstructorDao instructorDao, List<Logger> loggers) {
		this.instructorDao = instructorDao;
		this.loggers = loggers;
	}
	
	public void add(Instructor instructor) {
		
		instructorDao.add(instructor);
		
		for (Logger logger : loggers) {
			logger.log();
		}
		
	}
}
