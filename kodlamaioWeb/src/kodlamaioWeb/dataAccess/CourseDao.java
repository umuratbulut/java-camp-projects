package kodlamaioWeb.dataAccess;

import java.util.List;

import kodlamaioWeb.entities.Course;

public interface CourseDao {
	
	List<Course> getList();
	void add(Course course);
}
