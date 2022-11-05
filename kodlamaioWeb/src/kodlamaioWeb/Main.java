package kodlamaioWeb;

import java.util.ArrayList;

import kodlamaioWeb.business.CategoryManager;
import kodlamaioWeb.business.CourseManager;
import kodlamaioWeb.business.InstructorManager;
import kodlamaioWeb.core.DatabaseLogger;
import kodlamaioWeb.core.FileLogger;
import kodlamaioWeb.core.Logger;
import kodlamaioWeb.dataAccess.HibernateCourseDao;
import kodlamaioWeb.dataAccess.HibernateInstructorDao;
import kodlamaioWeb.dataAccess.JdbcCategoryDao;
import kodlamaioWeb.entities.Category;
import kodlamaioWeb.entities.Course;
import kodlamaioWeb.entities.Instructor;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		ArrayList<Logger> loggers = new ArrayList<Logger>();
		loggers.add(new FileLogger());
		loggers.add(new DatabaseLogger());
		
		CourseManager courseManager = new CourseManager(new HibernateCourseDao(), loggers);
		Course course = new Course(5, "React", 95);
		courseManager.add(course);
		
		CategoryManager categoryManager = new CategoryManager(new JdbcCategoryDao(), loggers);
		Category category = new Category(5, "Yazılım");
		categoryManager.add(category);
		
		InstructorManager instructorManager = new InstructorManager(new HibernateInstructorDao(), loggers);
		Instructor instructor = new Instructor(1, "Engin Demiroğ");
		instructorManager.add(instructor);
	}

}
