package kodlamaioWeb.dataAccess;

import java.util.ArrayList;
import java.util.List;

import kodlamaioWeb.entities.Course;

public class JdbcCourseDao implements CourseDao{

	@Override
	public List<Course> getList() {
		ArrayList<Course> dummyCourses = new ArrayList<Course>();
		dummyCourses.add(new Course(1,".Net Core", 250));
		dummyCourses.add(new Course(2,"JavaScript", 100));
		dummyCourses.add(new Course(3,"React", 250));
		
		return dummyCourses;
	}
	
	@Override
	public void add(Course course) {
		System.out.println(course.getName() + " verisi Jdbc ile eklendi.");
	}

}
