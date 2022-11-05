package kodlamaioWeb.business;

import java.util.List;

import kodlamaioWeb.core.Logger;
import kodlamaioWeb.dataAccess.CourseDao;
import kodlamaioWeb.entities.Course;

public class CourseManager {

	private CourseDao courseDao;
	private List<Logger> loggers;
	
	public CourseManager(CourseDao courseDao, List<Logger> loggers) {
		
		this.courseDao = courseDao;
		this.loggers = loggers;
	}

	public void add(Course course) throws Exception {
		
		List<Course> courses = courseDao.getList();
		
		for (Course courseItem : courses) {
			if (courseItem.getName().toLowerCase().equals(course.getName().toLowerCase())) {
				throw new Exception(course.getName() + " kursu zaten mevcut.");
			}
		}
		
		if(course.getPrice()<0) {
			throw new Exception("Kurs fiyatı 0 dan küçük olamaz.");
		}
		
		courseDao.add(course);
		
		for (Logger logger : loggers) {
			logger.log();
		}
		
	}
}
